package io.eblock.eos4j.api.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author shenzucai
 * @time 2018.09.22 14:11
 */
@NoArgsConstructor
@Data
public class DataBean {
    /**
     * from : silktrader55
     * to : silktrader44
     * quantity : 1.0000 EOS
     * memo : test
     */

    private String from;
    private String to;
    private String quantity;
    private String memo;
}
