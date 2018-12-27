package io.eblock.eos4j.api.vo.transaction.action;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author shenzucai
 * @time 2018.09.22 14:11
 */
@NoArgsConstructor
@Data
public class InlineTracesBean {
    /**
     * receipt : {"receiver":"silktrader55","act_digest":"f566c208aa7324d5ead8d1fd4d1bb97803f57eea4245adce0f59dbd0f0abeefe","global_sequence":37023890,"recv_sequence":8,"auth_sequence":[["silktrader55",9]],"code_sequence":4,"abi_sequence":4}
     * act : {"account":"eosio.token","name":"transfer","authorization":[{"actor":"silktrader55","permission":"active"}],"data":{"from":"silktrader55","to":"silktrader44","quantity":"1.0000 EOS","memo":"test"},"hex_data":"50ca55c9dc0ca3c340c855c9dc0ca3c3102700000000000004454f53000000000474657374"}
     * context_free : false
     * elapsed : 15
     * cpu_usage : 0
     * console :
     * total_cpu_usage : 0
     * trx_id : 5d18dedb9d8d4b99350947c1ccbc49d477de00dd78cac3635401312dd4a78acd
     * block_num : 15640309
     * block_time : 2018-09-22T06:09:08.500
     * producer_block_id : null
     * account_ram_deltas : []
     * inline_traces : []
     */

    private ReceiptBean receipt;
    private ActBean act;
    private boolean context_free;
    private Long elapsed;
    private Long cpu_usage;
    private String console;
    private Long total_cpu_usage;
    private String trx_id;
    private Long block_num;
    private String block_time;
    private Object producer_block_id;
    private List<?> account_ram_deltas;
    private List<?> inline_traces;
    private Object except;
}
