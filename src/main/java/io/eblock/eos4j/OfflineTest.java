package io.eblock.eos4j;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.eblock.eos4j.api.exception.ApiException;
import io.eblock.eos4j.api.vo.SignParam;
import io.eblock.eos4j.api.vo.transaction.Transaction;
import io.eblock.eos4j.api.vo.transaction.push.TxRequest;

import javax.sound.midi.Soundbank;

/**
 * 
 * @author espritblock http://eblock.io
 *
 */
public class OfflineTest {

	public static void main(String[] args) {
		/* testOfflineTransfer();
		testOfflinebuyRam1();
		testOfflinedelegatebw();
		testOfflineCreate();*/
		// testOfflinebuyRam();
		//  testOfflinesellRam();
		 testOfflineundelegatebw();
	}

	public static void testOfflineCreate() {
		Rpc rpc = new Rpc("http://junglehistory.cryptolions.io:18888");
		// 获取离线签名参数
		SignParam params = rpc.getOfflineSignParams(60L);
		// 离线签名
		OfflineSign sign = new OfflineSign();
		// 交易信息
		String content = "";
		try {
			content = sign.createAccount(params, "5KEj96nBM2tbVAREnftv6868GHAcUjnxdLb1yV8XPexZYs52rZ2", "silktrader55",
					"daring123123", "EOS8cvmAJpaZds3mpRESiwL2U1KVjdSaszAMswHV7oSb6XDMcEFaK",
					"EOS8cvmAJpaZds3mpRESiwL2U1KVjdSaszAMswHV7oSb6XDMcEFaK", 8000L,"1.0000 EOS","1.0000 EOS",0L);
			System.out.println(content);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 广播交易
		try {
			Transaction tx = rpc.pushTransaction(content);
			System.out.println(tx.getTransactionId());
		} catch (ApiException ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getError().getCode());
			System.out.println(ex.getError().getError());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testOfflineundelegatebw() {
		Rpc rpc = new Rpc("http://jungle.cryptolions.io:18888");
		// 获取离线签名参数
		SignParam params = rpc.getOfflineSignParams(60L);
		// 离线签名
		OfflineSign sign = new OfflineSign();
		// 交易信息
		String content = "";
		try {
			content = sign.undelegatebw(params, "5KEj96nBM2tbVAREnftv6868GHAcUjnxdLb1yV8XPexZYs52rZ2", "silktrader55",
					"silktrader55", "1.0000 EOS",
					"1.0000 EOS");
			System.out.println(content);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 50ca55c9dc0ca3c350ca55c9dc0ca3c3102700000000000004454f5300000000102700000000000004454f5300000000
		// 50ca55c9dc0ca3c350ca55c9dc0ca3c3102700000000000004454f5300000000102700000000000004454f5300000000
		// 广播交易
		try {
			Transaction tx = rpc.pushTransaction(content);
			System.out.println(tx.getTransactionId());
		} catch (ApiException ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getError().getCode());
			System.out.println(ex.getError().getError());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void testOfflinebuyRam() {
		Rpc rpc = new Rpc("https://jungle.eosio.cr:443");
		// 获取离线签名参数
		SignParam params = rpc.getOfflineSignParams(60L);
		// 离线签名
		OfflineSign sign = new OfflineSign();
		// 交易信息
		String content = "";
		try {
			content = sign.buyRam(params, "5KEj96nBM2tbVAREnftv6868GHAcUjnxdLb1yV8XPexZYs52rZ2", "silktrader55",
					"silktrader55", "1.0000 EOS");
			System.out.println(content);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 广播交易
		try {
			Transaction tx = rpc.pushTransaction(content);
			System.out.println(tx.getTransactionId());
		} catch (ApiException ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getError().getCode());
			System.out.println(ex.getError().getError());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testOfflinebuyRam1() {
		Rpc rpc = new Rpc("https://jungle.eosio.cr:443");
		// 获取离线签名参数
		SignParam params = rpc.getOfflineSignParams(60L);
		// 离线签名
		OfflineSign sign = new OfflineSign();
		// 交易信息
		String content = "";
		try {
			content = sign.buyRam(params, "5KEj96nBM2tbVAREnftv6868GHAcUjnxdLb1yV8XPexZYs52rZ2", "silktrader55",
					"silktrader55", 8183L);
			System.out.println(content);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 广播交易
		try {
			Transaction tx = rpc.pushTransaction(content);
			System.out.println(tx.getTransactionId());
		} catch (ApiException ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getError().getCode());
			System.out.println(ex.getError().getError());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void testOfflinesellRam() {
		Rpc rpc = new Rpc("http://jungle.cryptolions.io:18888");
		// 获取离线签名参数
		SignParam params = rpc.getOfflineSignParams(30L);
		// 离线签名
		OfflineSign sign = new OfflineSign();
		// 交易信息
		String content = "";
		try {
			content = sign.sellRam(params, "5KEj96nBM2tbVAREnftv6868GHAcUjnxdLb1yV8XPexZYs52rZ2", "silktrader55",
					 8183L);
			System.out.println(content);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 广播交易
		try {
			Transaction tx = rpc.pushTransaction(content);
			System.out.println(tx.getTransactionId());
		} catch (ApiException ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getError().getCode());
			System.out.println(ex.getError().getError());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void testOfflinedelegatebw() {
		Rpc rpc = new Rpc("http://junglehistory.cryptolions.io:18888");
		// 获取离线签名参数
		SignParam params = rpc.getOfflineSignParams(60L);
		// 离线签名
		OfflineSign sign = new OfflineSign();
		// 交易信息
		String content = "";
		try {
			content = sign.delegatebw(params, "5KEj96nBM2tbVAREnftv6868GHAcUjnxdLb1yV8XPexZYs52rZ2", "silktrader55",
					"silktrader55", "1.0000 EOS",
					"1.0000 EOS",0L);
			System.out.println(content);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 广播交易
		try {
			Transaction tx = rpc.pushTransaction(content);
			System.out.println(tx.getTransactionId());
		} catch (ApiException ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getError().getCode());
			System.out.println(ex.getError().getError());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testOfflineTransfer() {
		Rpc rpc = new Rpc("http://junglehistory.cryptolions.io:18888");
		// 获取离线签名参数
		SignParam params = rpc.getOfflineSignParams(60l);
		// 离线签名
		OfflineSign sign = new OfflineSign();
		// 交易信息
		String content = "";
		try {
			content = sign.transfer(params, "5KEj96nBM2tbVAREnftv6868GHAcUjnxdLb1yV8XPexZYs52rZ2", "eosio.token",
					"silktrader55", "silktrader44", "0.0993 EOS", "test");
			System.out.println(content);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 广播交易
		try {
			Transaction tx = rpc.pushTransaction(content);
			System.out.println(tx.getTransactionId());
		} catch (ApiException ex) {
			System.out.println(ex.getError().getCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
