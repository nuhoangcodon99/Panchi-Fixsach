package com.girlkun.models.boss.list_boss.TrainOffline;

import com.girlkun.models.boss.*;
import com.girlkun.models.map.Zone;

/**
 * @Stole By MITCHIKEN ZALO 0358689793
 */
public class Bill extends TrainBoss {

    public Bill(byte bossID, BossData bossData, Zone zone, int x, int y) throws Exception {
        super(BossID.BILL, BossesData.BILL,zone,x,y);
    }
}