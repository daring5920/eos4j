package io.eblock.eos4j.api.vo.transaction.action;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author shenzucai
 * @time 2018.09.22 15:42
 */
@NoArgsConstructor
@Data
public class AuthorizationBean {
    /**
     * actor : scott
     * permission : active
     */

    private String actor;
    private String permission;
}
