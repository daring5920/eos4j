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
public class ActBean {
    /**
     * account : eosio.token
     * name : transfer
     * authorization : [{"actor":"scott","permission":"active"}]
     * data : {"from":"scott","to":"exchange","quantity":"1.0000 EOS","memo":""}
     * hex_data : 00000000809c29c20000008a4dd35057102700000000000004454f530000000000
     */

    private String account;
    private String name;
    private Object data;
    private String hex_data;
    private List<AuthorizationBean> authorization;
}
