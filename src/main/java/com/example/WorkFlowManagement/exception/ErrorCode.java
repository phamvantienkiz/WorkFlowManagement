package com.example.WorkFlowManagement.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized exception"),
    INVALID_KEY(1001, "Invalid message key"),
    USER_EXISTED(1002, "User existed"),
    USERNAME_INVALID(1003, "Username must be at least 3 characters"),
    INVALID_PASSWORD(1004, "Password must be at least 3 characters"),
    USER_NOT_EXISTED(1005, "User not existed"),
    UNAUTHENTICATED(1005, "Unauthenticated"),
    LIST_BOARD_NOT_EXISTED(2001, "List board not existed"),
    BOARD_NOT_EXISTED(2002, "List board not existed"),
    CARD_NOT_EXISTED(2003, "Card not existed")
    ;
    private int code;
    private String messgae;

    ErrorCode(int code, String messgae) {
        this.code = code;
        this.messgae = messgae;
    }
}
