package io.eblock.eos4j.api.vo.transaction.action;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author shenzucai
 * @time 2018.09.22 15:42
 */
@NoArgsConstructor
@Data
public class ActionTraceBean {
    /**
     * receipt : {"receiver":"exchange","act_digest":"00686ff415fe97951a942889dbaed2b880043e3ae6ac2d5579318bbb2d30060f","global_sequence":32856,"recv_sequence":3,"auth_sequence":[["scott",43]]}
     * act : {"account":"eosio.token","name":"transfer","authorization":[{"actor":"scott","permission":"active"}],"data":{"from":"scott","to":"exchange","quantity":"1.0000 EOS","memo":""},"hex_data":"00000000809c29c20000008a4dd35057102700000000000004454f530000000000"}
     * elapsed : 52
     * cpu_usage : 1000
     * console :
     * total_inline_cpu_usage : 1000
     * trx_id : 213f37972498cbae5abf6bcb5aec82e09967df7f04cf90f67b7d63a6bb871d58
     * inline_traces : []
     */

    private ReceiptBean receipt;
    private boolean context_free;
    private ActBean act;
    private Long elapsed;
    private Long cpu_usage;
    private String console;
    private Long total_cpu_usage;
    private String trx_id;
    private Long block_num;
    private String block_time;
    private Object producer_block_id;
    private List<?> account_ram_deltas;
    private List<InlineTracesBean> inline_traces;

    private Object except;

}
