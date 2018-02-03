package com.lichao.chaovolley.db;

import android.os.Environment;
import com.lichao.chaovolley.User;
import com.lichao.chaovolley.UserDao;
import java.io.File;

/**
 * Created by Administrator on 2018-02-03.
 */

public enum PrivateDataBaseEnums {
    /**
     * 存放本地数据库的路径
     */
    database("local/data/database/");

    /**
     * 文件存储的文件路径
     */
    private String value;

    PrivateDataBaseEnums(String value ) {
        this.value = value;
    }

    public String getValue() {
        UserDao userDao = BaseDaoFactory.getInstance().getDataHelper(UserDao.class, User.class);
        if(userDao!=null) {
            User currentUser = userDao.getCurrentUser();
            if(currentUser!=null) {
                File file=new File(Environment.getExternalStorageDirectory(),"update");
                if(!file.exists()) {
                    file.mkdirs();
                }
                return file.getAbsolutePath()+"/"+currentUser.getUser_id()+"/logic.db";
            }
        }
        return value;
    }
}
