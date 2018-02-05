package com.lichao.chaovolley;

import com.lichao.chaovolley.db.annotion.DbTable;

/**
 * Created by Administrator on 2018-02-05.
 */

@DbTable("tb_photo")
public class Photo {
    public String time;

    public String path;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
