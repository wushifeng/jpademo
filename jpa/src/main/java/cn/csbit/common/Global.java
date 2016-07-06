package cn.csbit.common;

/**
 * 全局配置类
 */
public class Global {
    public interface DbType {
        byte ORACLE = 0;
        byte MSSQL = 1;
        byte DB2 = 2;
        byte MYSQL = 3;
        byte CACHE = 4;
        byte SYBASE = 5;
        byte DAMENG = 6;
        byte Informix = 7;
        byte ST = 8;
        byte King = 9;
        byte TeraData = 10;
        byte PostgreSQL = 11;
        byte GBase = 12;
        // 初始以达梦7为开发对象，后来发现7和6是不兼容的升级，jdbc无法共用，因此添加达梦6
        byte DAMENG6 = 13;
    }

    /**
     * Controller 返回结果
     */
    public interface RESULT {
        String SUCCESS = "success";
        String ERROR = "error";
    }

    /**
     * 加密解密任务执行状态
     */
    public interface TaskStatus {
        byte STOP = 0;
        byte RUNNING = 1;
    }

    /**
     * 加密算法
     */
    public interface EncryptAlgorithm {
        byte AES = 0;
        byte DES = 1;
    }
}
