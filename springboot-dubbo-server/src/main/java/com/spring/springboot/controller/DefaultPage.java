package com.spring.springboot.controller;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by whyang on 2017/07/06.
 */

@RestController
public class DefaultPage {

    @RequestMapping(value = "/zkget", method = RequestMethod.GET)
    public String defaultPage(){

        String value = null;
        Watcher watcher = new Watcher() {
            // 监控所有被触发的事件
            public void process(WatchedEvent event) {
                //dosomething
            }
        };

        try {
            final ZooKeeper zkpr = new ZooKeeper("192.168.178.134:2181", 500000, watcher);

            final byte[] data = zkpr.getData("/node_001", watcher, null);
            value = data.toString();
            zkpr.close();

        } catch (Exception e){}

        return "nodes from ZooKeeper:\t" + value;
    }

}
