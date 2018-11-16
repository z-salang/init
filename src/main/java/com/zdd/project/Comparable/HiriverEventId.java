package com.zdd.project.Comparable;

import org.apache.commons.lang3.StringUtils;

/**
 * @author shifeng.luo
 * @version created on 2017/12/19 下午2:45
 */
public class HiriverEventId implements Comparable<HiriverEventId> {

    private static final String POINT = ".";
    private static final String COLON = ":";
    private static final String FILE_PREFIX = "mysql-bin";

    private String binlogPosition;
    private String fileId;
    private int fileOffset;
    private int batchOffset;


    public String encode() {
        return binlogPosition + COLON + batchOffset;
    }

    public void decode(String value) {
        String[] split = StringUtils.split(value, COLON);
        if (split == null || split.length != 3) {
            throw new IllegalArgumentException("illegal hiriver event id");
        }

        try {
            batchOffset = Integer.valueOf(split[2]);
            fileOffset = Integer.valueOf(split[1]);
        } catch (Throwable e) {
            throw new IllegalArgumentException("illegal hiriver event id", e);
        }

        String[] strings = StringUtils.split(split[0], POINT);
        if (strings == null || strings.length != 2) {
            throw new IllegalArgumentException("illegal hiriver bin log file is illegal");
        }

        fileId = strings[1];
        if (!FILE_PREFIX.equals(strings[0])) {
            throw new IllegalArgumentException("illegal hiriver bin log file prefix is illegal");
        }

        if (!StringUtils.isNumeric(fileId)) {
            throw new IllegalArgumentException("illegal hiriver bin log file id is not Numeric");
        }
        binlogPosition = FILE_PREFIX + POINT + fileId + COLON + fileOffset;
    }

    @Override
    public int compareTo(HiriverEventId eventId) {
        int thisFileId = Integer.valueOf(fileId);
        int compareFileId = Integer.valueOf(eventId.fileId);
        if (thisFileId != compareFileId) {
            return thisFileId - compareFileId;
        }

        if (fileOffset != eventId.fileOffset) {
            return fileOffset - eventId.fileOffset;
        }

        if (batchOffset != eventId.batchOffset) {
            return batchOffset - eventId.batchOffset;
        }

        return 0;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HiriverEventId eventId = (HiriverEventId) o;

        if (fileOffset != eventId.fileOffset) return false;
        if (batchOffset != eventId.batchOffset) return false;
        if (binlogPosition != null ? !binlogPosition.equals(eventId.binlogPosition) : eventId.binlogPosition != null)
            return false;
        return fileId != null ? fileId.equals(eventId.fileId) : eventId.fileId == null;
    }

    @Override
    public int hashCode() {
        int result = binlogPosition != null ? binlogPosition.hashCode() : 0;
        result = 31 * result + (fileId != null ? fileId.hashCode() : 0);
        result = 31 * result + fileOffset;
        result = 31 * result + batchOffset;
        return result;
    }

    public String getBinlogPosition() {
        return binlogPosition;
    }

    public void setBinlogPosition(String binlogPosition) {
        this.binlogPosition = binlogPosition;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public int getFileOffset() {
        return fileOffset;
    }

    public void setFileOffset(int fileOffset) {
        this.fileOffset = fileOffset;
    }

    public int getBatchOffset() {
        return batchOffset;
    }

    public void setBatchOffset(int batchOffset) {
        this.batchOffset = batchOffset;
    }
}
