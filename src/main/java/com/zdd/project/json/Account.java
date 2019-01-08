package com.zdd.project.json;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2019/1/8 下午5:02
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private long accountId;
    private long balance;
    private String name;
}
