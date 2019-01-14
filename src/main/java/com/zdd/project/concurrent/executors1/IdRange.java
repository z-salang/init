package com.zdd.project.concurrent.executors1;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2019/1/12 下午2:24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IdRange {
    private long from;
    private long to;

    public static List<IdRange> allocationIdRange(long start, long end, int segmentSize) {
        List<IdRange> ranges = new ArrayList<>();
        if (start >= end) {
            return new ArrayList<>();
        }

        long length = end - start;
        int segment = (int) (length / segmentSize);

        if (length % segmentSize != 0) {
            segment += 1;
        }

        if (segment > 1) {
            long offset = start;
            for (int i = 1; i <= segment; ++i) {
                long rangeFrom = offset + 1;
                long rangeTo = offset + segmentSize;

                if (rangeTo > end) {
                    rangeTo = end;
                }

                ranges.add(new IdRange(rangeFrom, rangeTo));
                offset = rangeTo;
            }
        } else {
            ranges.add(new IdRange(start + 1, end));
        }

        return ranges;
    }
}
