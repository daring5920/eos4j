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
public class ReceiptBean {
    /**
     * receiver : exchange
     * act_digest : 00686ff415fe97951a942889dbaed2b880043e3ae6ac2d5579318bbb2d30060f
     * global_sequence : 32856
     * recv_sequence : 3
     * auth_sequence : [["scott",43]]
     */

    private String receiver;
    private String act_digest;
    private Long global_sequence;
    private Long recv_sequence;
    private Long code_sequence;
    private Long abi_sequence;
    private List<List<String>> auth_sequence;
}
