package com.lichao.chaovolley;

import com.lichao.chaovolley.db.BaseDao;

import java.util.List;

/**
 * Created by Administrator on 2018-02-05.
 */

public class PhotoDao extends BaseDao<Photo> {

    @Override
    public List<Photo> query(String sql) {
        return null;
    }

    @Override
    public String createTable() {
        return "create table if not exists tb_photo(\n" +
                "                time TEXT,\n" +
                "                path TEXT,\n" +
                "                to_user TEXT\n" +
                "                )";
    }
}
