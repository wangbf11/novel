package com.example.myread;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.read.booklibrary.model.bean.CollBookBean;
import com.read.booklibrary.utils.JSONUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String json = "{\"_id\":\"546039ec39216f8e350b2bbf\",\"author\":\"平凡魔术师\",\"chaptersCount\":773,\"cover\":\"/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F685968%2F685968_4e1c1cdfd49b42ea9fec9df0389d869c.jpg%2F\",\"hasCp\":true,\"isLocal\":false,\"isUpdate\":true,\"lastChapter\":\"773 心痒痒（大结局）\",\"lastRead\":\"2019-02-18T18:12:29\",\"latelyFollower\":24198,\"retentionRatio\":50.31,\"shortIntro\":\"叶扬穿越异世，得九天玄剑认主，习神秘功法《戮神诀》，走上一条靠杀戮修行之路。逐渐揭开九天玄剑陨落之谜，杀上神界，血染九天。\\n叶扬一出天地轻， 长枪横扫血犹腥。 浅水蛟龙冲云起， 九天十地鬼神惊。 …… 且看叶扬如何啸傲九天。\",\"title\":\"灵武弑九天\",\"updated\":\"2015-09-01T18:35:16.003Z\"}";
        CollBookBean collBookBean = JSONUtil.parseJSON(json, CollBookBean.class);
        MyReadActivity.startActivity(this,collBookBean,false,MyReadActivity.class);

    }
}
