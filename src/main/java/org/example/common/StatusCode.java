package org.example.common;

/**
 * @Description
 * @Author: lyc
 * @Date: 2025/1/6
 */
public enum StatusCode {
    // 成功
    SUCCESS(true,200,"成功"),

    // 客户端错误
    CLIENT_ERROR(false,400,"客户端错误"),
    PARAM_ERROR(false,401,"参数错误"),

    // 服务端错误
    SERVER_ERROR(false,500,"客户端错误"),
    DATABASE_ERROR(false, 501, "数据库错误"),
    UNKNOWN_ERROR(false,502,"未知错误");

    private  Boolean success;
    private  Integer code;
    private  String message;

    StatusCode(boolean success, Integer code, String message) {
        this.success =success;
        this.code = code;
        this.message =message;
    }

    // 获取状态码
    public int getCode() {
        return code;
    }

    // 获取状态信息
    public String getMessage() {
        return message;
    }

    // 获取是否成功
    public boolean isSuccess() {
        return success;
    }

    @Override
    public String toString() {
        return "StatusCode{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

    // 根据code获取对应的枚举
    public static StatusCode getByCode(int code) {
        for (StatusCode statusCode : values()) {
            if (statusCode.getCode() == code) {
                return statusCode;
            }
        }
        return UNKNOWN_ERROR;  // 默认返回UNKNOWN_ERROR
    }
}
