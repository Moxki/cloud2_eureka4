package com.mox.entity;

import lombok.Data;

@Data
public class AoaCatalog {
    private int catalogId;
    private String catalogName;
    private int parentId;
    private int cataUserId;
}
