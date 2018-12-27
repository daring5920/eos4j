package io.eblock.eos4j;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.eblock.eos4j.api.vo.Block;
import io.eblock.eos4j.api.vo.ChainInfo;
import io.eblock.eos4j.api.vo.SignParam;
import io.eblock.eos4j.api.vo.transaction.push.Tx;
import io.eblock.eos4j.api.vo.transaction.push.TxAction;
import io.eblock.eos4j.api.vo.transaction.push.TxRequest;
import io.eblock.eos4j.api.vo.transaction.push.TxSign;
import io.eblock.eos4j.ese.Action;
import io.eblock.eos4j.ese.DataParam;
import io.eblock.eos4j.ese.DataType;
import io.eblock.eos4j.ese.Ese;

/**
 * 
 * @author espritblock http://eblock.io
 *
 */
public class OfflineSign {

	SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

	public OfflineSign() {
		dateFormatter.setTimeZone(TimeZone.getTimeZone("UTC"));
	}

	/**
	 * 
	 * @param compression
	 * @param pushTransaction
	 * @param signatures
	 * @return
	 * @throws Exception
	 */
	public String pushTransaction(String compression, Tx pushTransaction, String[] signatures) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		String mapJakcson = mapper.writeValueAsString(new TxRequest(compression, pushTransaction, signatures));
		return mapJakcson;
	}

	/**
	 * 离线签名转账
	 * 
	 * @param signParam
	 * @param pk
	 * @param contractAccount
	 * @param from
	 * @param to
	 * @param quantity
	 * @param memo
	 * @return
	 * @throws Exception
	 */
	public String transfer(SignParam signParam, String pk, String contractAccount, String from, String to,
			String quantity, String memo) throws Exception {
		Tx tx = new Tx();
		tx.setExpiration(signParam.getHeadBlockTime().getTime() / 1000 + signParam.getExp());
		tx.setRef_block_num(signParam.getLastIrreversibleBlockNum());
		tx.setRef_block_prefix(signParam.getRefBlockPrefix());
		tx.setNet_usage_words(0L);
		tx.setMax_cpu_usage_ms(0L);
		tx.setDelay_sec(0L);
		// actions
		List<TxAction> actions = new ArrayList<>();
		// data
		Map<String, Object> dataMap = new LinkedHashMap<>();
		dataMap.put("from", from);
		dataMap.put("to", to);
		dataMap.put("quantity", new DataParam(quantity, DataType.asset, Action.transfer).getValue());
		dataMap.put("memo", memo);
		// action
		TxAction action = new TxAction(from, contractAccount, "transfer", dataMap);
		actions.add(action);
		tx.setActions(actions);
		// sgin
		String sign = Ecc.signTransaction(pk, new TxSign(signParam.getChainId(), tx));
		// data parse
		String data = Ecc.parseTransferData(from, to, quantity, memo);
		// reset data
		action.setData(data);
		// reset expiration
		tx.setExpiration(dateFormatter.format(new Date(1000 * Long.parseLong(tx.getExpiration().toString()))));
		return pushTransaction("none", tx, new String[] { sign });
	}

	/**
	 * 离线签名创建账户
	 * 
	 * @param signParam
	 * @param pk
	 * @param creator
	 * @param newAccount
	 * @param owner
	 * @param active
	 * @param buyRam
	 * @return
	 * @throws Exception
	 */
	public String createAccount(SignParam signParam, String pk, String creator, String newAccount, String owner,
			String active, Long buyRam) throws Exception {
		Tx tx = new Tx();
		tx.setExpiration(signParam.getHeadBlockTime().getTime() / 1000 + signParam.getExp());
		tx.setRef_block_num(signParam.getLastIrreversibleBlockNum());
		tx.setRef_block_prefix(signParam.getRefBlockPrefix());
		tx.setNet_usage_words(0L);
		tx.setMax_cpu_usage_ms(0L);
		tx.setDelay_sec(0L);
		// actions
		List<TxAction> actions = new ArrayList<>();
		tx.setActions(actions);
		// create
		Map<String, Object> createMap = new LinkedHashMap<>();
		createMap.put("creator", creator);
		createMap.put("name", newAccount);
		createMap.put("owner", owner);
		createMap.put("active", active);
		TxAction createAction = new TxAction(creator, "eosio", "newaccount", createMap);
		actions.add(createAction);
		// buyrap
		Map<String, Object> buyMap = new LinkedHashMap<>();
		buyMap.put("payer", creator);
		buyMap.put("receiver", newAccount);
		buyMap.put("bytes", buyRam);
		TxAction buyAction = new TxAction(creator, "eosio", "buyrambytes", buyMap);
		actions.add(buyAction);
		// sgin
		String sign = Ecc.signTransaction(pk, new TxSign(signParam.getChainId(), tx));
		// data parse
		String accountData = Ese.parseAccountData(creator, newAccount, owner, active);
		createAction.setData(accountData);
		// data parse
		String ramData = Ese.parseBuyRamData(creator, newAccount, buyRam);
		buyAction.setData(ramData);
		// reset expiration
		tx.setExpiration(dateFormatter.format(new Date(1000 * Long.parseLong(tx.getExpiration().toString()))));
		return pushTransaction("none", tx, new String[] { sign });
	}


	/**
	 * 创建账户
	 *
	 * @param pk
	 *            私钥
	 * @param creator
	 *            创建者
	 * @param newAccount
	 *            新账户
	 * @param owner
	 *            公钥
	 * @param active
	 *            公钥
	 * @param buyRam
	 *            购买空间数量
	 * @param stakeNetQuantity
	 *            网络抵押
	 * @param stakeCpuQuantity
	 *            cpu抵押
	 * @param transfer
	 *            抵押资产是否转送给对方，0自己所有，1对方所有
	 * @return
	 * @throws Exception
	 */
	public String createAccount(SignParam signParam,String pk, String creator, String newAccount, String owner, String active,
																		Long buyRam, String stakeNetQuantity, String stakeCpuQuantity, Long transfer) throws Exception {
		// tx
		Tx tx = new Tx();
		tx.setExpiration(signParam.getHeadBlockTime().getTime() / 1000 + signParam.getExp());
		tx.setRef_block_num(signParam.getLastIrreversibleBlockNum());
		tx.setRef_block_prefix(signParam.getRefBlockPrefix());
		tx.setNet_usage_words(0L);
		tx.setMax_cpu_usage_ms(0L);
		tx.setDelay_sec(0L);
		// actions
		List<TxAction> actions = new ArrayList<>();
		tx.setActions(actions);
		// create
		Map<String, Object> createMap = new LinkedHashMap<>();
		createMap.put("creator", creator);
		createMap.put("name", newAccount);
		createMap.put("owner", owner);
		createMap.put("active", active);
		TxAction createAction = new TxAction(creator, "eosio", "newaccount", createMap);
		actions.add(createAction);
		// buyrap
		Map<String, Object> buyMap = new LinkedHashMap<>();
		buyMap.put("payer", creator);
		buyMap.put("receiver", newAccount);
		buyMap.put("bytes", buyRam);
		TxAction buyAction = new TxAction(creator, "eosio", "buyrambytes", buyMap);
		actions.add(buyAction);
		// buyrap
		Map<String, Object> delMap = new LinkedHashMap<>();
		delMap.put("from", creator);
		delMap.put("receiver", newAccount);
		delMap.put("stake_net_quantity", new DataParam(stakeNetQuantity, DataType.asset, Action.delegate).getValue());
		delMap.put("stake_cpu_quantity", new DataParam(stakeCpuQuantity, DataType.asset, Action.delegate).getValue());
		delMap.put("transfer", transfer);
		TxAction delAction = new TxAction(creator, "eosio", "delegatebw", delMap);
		actions.add(delAction);
		// // sgin
		String sign = Ecc.signTransaction(pk, new TxSign(signParam.getChainId(), tx));
		// data parse
		String accountData = Ese.parseAccountData(creator, newAccount, owner, active);
		createAction.setData(accountData);
		// data parse
		String ramData = Ese.parseBuyRamData(creator, newAccount, buyRam);
		buyAction.setData(ramData);
		// data parse
		String delData = Ese.parseDelegateData(creator, newAccount, stakeNetQuantity, stakeCpuQuantity,
				transfer.intValue());
		delAction.setData(delData);
		// reset expiration
		tx.setExpiration(dateFormatter.format(new Date(1000 * Long.parseLong(tx.getExpiration().toString()))));
		return pushTransaction("none", tx, new String[] {sign});
	}

	/**
	 * 离线签名购买ram
	 *
	 * @param signParam
	 * @param pk
	 * @param payer
	 * @param ramer
	 * @param buyRam
	 * @return
	 * @throws Exception
	 */
	public String buyRam(SignParam signParam, String pk, String payer, String ramer, Long buyRam) throws Exception {
		Tx tx = new Tx();
		tx.setExpiration(signParam.getHeadBlockTime().getTime() / 1000 + signParam.getExp());
		tx.setRef_block_num(signParam.getLastIrreversibleBlockNum());
		tx.setRef_block_prefix(signParam.getRefBlockPrefix());
		tx.setNet_usage_words(0L);
		tx.setMax_cpu_usage_ms(0L);
		tx.setDelay_sec(0L);
		// actions
		List<TxAction> actions = new ArrayList<>();
		tx.setActions(actions);
		// buyram
		Map<String, Object> buyMap = new LinkedHashMap<>();
		buyMap.put("payer", payer);
		buyMap.put("receiver", ramer);
		buyMap.put("bytes", buyRam);
		TxAction buyAction = new TxAction(payer, "eosio", "buyrambytes", buyMap);
		actions.add(buyAction);
		// sgin
		String sign = Ecc.signTransaction(pk, new TxSign(signParam.getChainId(), tx));
		// data parse
		String ramData = Ese.parseBuyRamData(payer, ramer, buyRam);
		buyAction.setData(ramData);
		// reset expiration
		tx.setExpiration(dateFormatter.format(new Date(1000 * Long.parseLong(tx.getExpiration().toString()))));
		return pushTransaction("none", tx, new String[] { sign });
	}


	/**
	 * 离线签名购买ram
	 *
	 * @param signParam
	 * @param pk
	 * @param payer
	 * @param ramer
	 * @param tokens
	 * @return
	 * @throws Exception
	 */
	public String buyRam(SignParam signParam, String pk, String payer, String ramer, String tokens) throws Exception {
		Tx tx = new Tx();
		tx.setExpiration(signParam.getHeadBlockTime().getTime() / 1000 + signParam.getExp());
		tx.setRef_block_num(signParam.getLastIrreversibleBlockNum());
		tx.setRef_block_prefix(signParam.getRefBlockPrefix());
		tx.setNet_usage_words(0L);
		tx.setMax_cpu_usage_ms(0L);
		tx.setDelay_sec(0L);
		// actions
		List<TxAction> actions = new ArrayList<>();
		tx.setActions(actions);
		// buyram
		Map<String, Object> buyMap = new LinkedHashMap<>();
		buyMap.put("payer", payer);
		buyMap.put("receiver", ramer);
		buyMap.put("quant", new DataParam(tokens, DataType.asset, Action.delegate).getValue());
		TxAction buyAction = new TxAction(payer, "eosio", "buyram", buyMap);
		actions.add(buyAction);
		// sgin
		String sign = Ecc.signTransaction(pk, new TxSign(signParam.getChainId(), tx));
		// data parse
		String ramData = Ese.parseBuyRamData(payer, ramer, tokens);
		buyAction.setData(ramData);
		// reset expiration
		tx.setExpiration(dateFormatter.format(new Date(1000 * Long.parseLong(tx.getExpiration().toString()))));
		return pushTransaction("none", tx, new String[] { sign });
	}

	/**
	 * 离线签名出售ram
	 *
	 * @param signParam
	 * @param pk
	 * @param payer
	 * @param sellRam
	 * @return
	 * @throws Exception
	 */
	public String sellRam(SignParam signParam, String pk, String payer, Long sellRam) throws Exception {
		Tx tx = new Tx();
		tx.setExpiration(signParam.getHeadBlockTime().getTime() / 1000 + signParam.getExp());
		tx.setRef_block_num(signParam.getLastIrreversibleBlockNum());
		tx.setRef_block_prefix(signParam.getRefBlockPrefix());
		tx.setNet_usage_words(0L);
		tx.setMax_cpu_usage_ms(0L);
		tx.setDelay_sec(0L);
		// actions
		List<TxAction> actions = new ArrayList<>();
		tx.setActions(actions);
		// buyram
		Map<String, Object> buyMap = new LinkedHashMap<>();
		buyMap.put("account", payer);
		buyMap.put("bytes", sellRam);
		TxAction buyAction = new TxAction(payer, "eosio", "sellram", buyMap);
		actions.add(buyAction);
		// sgin
		String sign = Ecc.signTransaction(pk, new TxSign(signParam.getChainId(), tx));
		// data parse
		String ramData = Ese.parseSellRamData(payer,sellRam);
		buyAction.setData(ramData);
		// reset expiration
		tx.setExpiration(dateFormatter.format(new Date(1000 * Long.parseLong(tx.getExpiration().toString()))));
		return pushTransaction("none", tx, new String[] { sign });
	}

	/**
	 * 离线签名抵押cpu，net
	 * @author shenzucai
	 * @time 2018.11.05 19:45
	 * @param signParam
	 * @param pk
	 * @param payer
	 * @param newAccount
	 * @param stakeNetQuantity 网络抵押
	 * @param stakeCpuQuantity  cpu抵押
	 * @param transfer 抵押资产是否转送给对方，0自己所有，1对方所有
	 * @return true
	 */
	public String delegatebw(SignParam signParam, String pk, String payer,String newAccount,String stakeNetQuantity, String stakeCpuQuantity, Long transfer) throws Exception {
		Tx tx = new Tx();
		tx.setExpiration(signParam.getHeadBlockTime().getTime() / 1000 + signParam.getExp());
		tx.setRef_block_num(signParam.getLastIrreversibleBlockNum());
		tx.setRef_block_prefix(signParam.getRefBlockPrefix());
		tx.setNet_usage_words(0L);
		tx.setMax_cpu_usage_ms(0L);
		tx.setDelay_sec(0L);
		// actions
		List<TxAction> actions = new ArrayList<>();
		tx.setActions(actions);
		// delegatebw
		Map<String, Object> delMap = new LinkedHashMap<>();
		delMap.put("from", payer);
		delMap.put("receiver", newAccount);
		delMap.put("stake_net_quantity", new DataParam(stakeNetQuantity, DataType.asset, Action.delegate).getValue());
		delMap.put("stake_cpu_quantity", new DataParam(stakeCpuQuantity, DataType.asset, Action.delegate).getValue());
		delMap.put("transfer", transfer);
		TxAction delAction = new TxAction(payer, "eosio", "delegatebw", delMap);
		actions.add(delAction);
		// sgin
		String sign = Ecc.signTransaction(pk, new TxSign(signParam.getChainId(), tx));
		// data parse
		String delData = Ese.parseDelegateData(payer, newAccount, stakeNetQuantity, stakeCpuQuantity,
				transfer.intValue());
		delAction.setData(delData);
		// reset expiration
		tx.setExpiration(dateFormatter.format(new Date(1000 * Long.parseLong(tx.getExpiration().toString()))));
		return pushTransaction("none", tx, new String[] { sign });
	}

	/**
	 * 离线签名取消抵押cpu，net
	 * @author shenzucai
	 * @time 2018.11.05 19:45
	 * @param signParam
	 * @param pk
	 * @param payer
	 * @param newAccount
	 * @param unstakeNetQuantity 网络抵押
	 * @param unstakeCpuQuantity  cpu抵押
	 * @return true
	 */
	public String undelegatebw(SignParam signParam, String pk, String payer,String newAccount,String unstakeNetQuantity, String unstakeCpuQuantity) throws Exception {
		Tx tx = new Tx();
		tx.setExpiration(signParam.getHeadBlockTime().getTime() / 1000 + signParam.getExp());
		tx.setRef_block_num(signParam.getLastIrreversibleBlockNum());
		tx.setRef_block_prefix(signParam.getRefBlockPrefix());
		tx.setNet_usage_words(0L);
		tx.setMax_cpu_usage_ms(0L);
		tx.setDelay_sec(0L);
		// actions
		List<TxAction> actions = new ArrayList<>();
		tx.setActions(actions);
		// delegatebw
		Map<String, Object> delMap = new LinkedHashMap<>();
		delMap.put("from", payer);
		delMap.put("receiver", newAccount);
		delMap.put("unstake_net_quantity ", new DataParam(unstakeNetQuantity, DataType.asset, Action.delegate).getValue());
		delMap.put("unstake_cpu_quantity ", new DataParam(unstakeCpuQuantity, DataType.asset, Action.delegate).getValue());
		TxAction delAction = new TxAction(payer, "eosio", "undelegatebw", delMap);
		actions.add(delAction);
		// sgin
		String sign = Ecc.signTransaction(pk, new TxSign(signParam.getChainId(), tx));
		// data parse
		String delData = Ese.parseUnDelegateData(payer, newAccount, unstakeNetQuantity, unstakeCpuQuantity);
		delAction.setData(delData);
		// reset expiration
		tx.setExpiration(dateFormatter.format(new Date(1000 * Long.parseLong(tx.getExpiration().toString()))));
		return pushTransaction("none", tx, new String[] { sign });
	}
}
