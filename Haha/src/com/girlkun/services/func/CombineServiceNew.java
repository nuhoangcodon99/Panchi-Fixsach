package com.girlkun.services.func;

import com.girlkun.consts.ConstNpc;
import com.girlkun.models.item.Item;
import com.girlkun.models.item.Item.ItemOption;
import com.girlkun.models.map.ItemMap;
import com.girlkun.models.npc.Npc;
import com.girlkun.models.npc.NpcManager;
import com.girlkun.models.player.Player;
import com.girlkun.server.Manager;
import com.girlkun.server.ServerNotify;
import com.girlkun.network.io.Message;
import com.girlkun.services.*;
import com.girlkun.utils.Logger;
import com.girlkun.utils.Util;

import java.util.*;
import java.util.stream.Collectors;

public class CombineServiceNew {

    private static final int COST_DOI_VE_DOI_DO_HUY_DIET = 500000000;
    private static final int COST_DAP_DO_KICH_HOAT = 1000000000;
    private static final int RUBY_DAP_DO_KICH_HOAT = 10000;
    private static final int GEM_DAP_DO_KICH_HOAT = 10000;
    private static final int COST_DOI_KICH_HOAT = 1000000;
    private static final int COST_DOI_MANH_KICH_HOAT = 500000000;

    private static final int COST = 500000000;
    private static final int RUBY = 20000;

    private static final long COST_TINH_LUYEN = 40_000_000_000L;
    private static final int RUBY_TINH_LUYEN = 10000;
    private static final int GEM_TINH_LUYEN = 10000;

    private static final int TIME_COMBINE = 1500;

    private static final byte MAX_STAR_ITEM = 8;
    private static final byte MAX_EP_CHUNG_NHAN = 30;
    private static final byte MAX_STAR_ITEM_TC1 = 17;
    private static final byte MAX_LEVEL_ITEM = 8;

    private static final byte OPEN_TAB_COMBINE = 0;
    private static final byte REOPEN_TAB_COMBINE = 1;
    private static final byte COMBINE_SUCCESS = 2;
    private static final byte COMBINE_FAIL = 3;
    private static final byte COMBINE_CHANGE_OPTION = 4;
    private static final byte COMBINE_DRAGON_BALL = 5;
    public static final byte OPEN_ITEM = 6;
    public static final int NANG_HUY_DIET_LEN_SKH_VIP = 555;
    public static final int NANG_CAP_CHAN_MENH = 5380;
    public static final int EP_SAO_TRANG_BI = 500;
    public static final int PHA_LE_HOA_TRANG_BI = 501;
    public static final int CHUYEN_HOA_TRANG_BI = 502;
    public static final int DOI_SKH_THANH_DNS = 503;
    public static final int DAP_SET_KICH_HOAT = 504;
    public static final int DAP_SET_KICH_HOAT_AO = 505;
    public static final int DAP_SET_KICH_HOAT_QUAN = 506;
    public static final int DAP_SET_KICH_HOAT_GANG = 507;
    public static final int DAP_SET_KICH_HOAT_GIAY = 508;
    public static final int DOI_DIEM = 595;
    public static final int THUC_TINH_DT = 529;
    public static final int DAP_SET_KICH_HOAT_NHAN = 509;
    public static final int DAP_SET_KICH_HOAT_HD = 10000;
    public static final int DAP_SET_KICH_HOAT_TS = 10001;
    public static final int TAY_SKH_TRANG_BI = 10002;
    public static final int KHAC_CHI_SO_DA = 10003;
    public static final int KHAC_CHI_SO_NGOC_BOI = 10004;
    public static final int THANG_CAP_TRANG_BI = 10005;
    public static final int EP_SAO_TRANG_BI_THANG_CAP = 10007;
    public static final int TIEN_HOA_NGOC_BOI = 10008;
    public static final int TINH_LUYEN_TRANG_BI = 10009;
    public static final int REN_TRANG_BI = 100010;
    public static final int EP_CHUNG_NHAN_XUAT_SU = 5000;
    public static final int MO_CHI_SO_BI_TICH = 5001;
    public static final int LUYEN_BI_TICH = 5002;
    public static final int EP_DA_DANH_HIEU = 5003;
    public static final int PS_HOA_TRANG_BI = 2150;
    public static final int TAY_PS_HOA_TRANG_BI = 2151;
    public static final int NANG_CAP_CAI_TRANG_SSJ = 2149;
    public static final int TIEN_HOA_CAI_TRANG_BABY_VEGETA = 2148;
    public static final int TIEN_HOA_CAI_TRANG_BLACK_GOKU = 2147;
    public static final int TIEN_HOA_CAI_TRANG_BILL = 2146;
    public static final int TIEN_HOA_CAI_TRANG_HEARTS_GOLD = 2145;
    public static final int NANG_CAP_VAT_PHAM = 510;
    public static final int NANG_CAP_BONG_TAI = 511;
    public static final int MO_CHI_SO_BONG_TAI = 519;
    public static final int NANG_CAP_BONG_TAI_CAP3 = 5127;
    public static final int MO_CHI_SO_BONG_TAI_CAP3 = 5128;
    public static final int NANG_CAP_BONG_TAI_CAP4 = 5223;
    public static final int MO_CHI_SO_BONG_TAI_CAP4 = 5224;
    public static final int LAM_PHEP_NHAP_DA = 512;
    public static final int NHAP_NGOC_RONG = 513;
    public static final int MO_CHI_SO_CAI_TRANG = 539;
    public static final int PHAN_RA_DO_THAN_LINH = 514;
    public static final int NANG_CAP_DO_TS = 515;
    public static final int NANG_CAP_SKH_VIP = 516;
    public static final int AN_TRANG_BI = 517;
    public static final int CHE_TAO_TRANG_BI_TS = 520;

    // BKT _ SÁCH TUYỆT KỸ //
    public static final int GIAM_DINH_SACH = 1233;
    public static final int TAY_SACH = 1234;
    public static final int NANG_CAP_SACH_TUYET_KY = 1235;
    public static final int PHUC_HOI_SACH = 1236;
    public static final int PHAN_RA_SACH = 1237;

    private static final int GOLD_BONG_TAI = 50000000;
    private static final int GEM_BONG_TAI = 500;
    private static final int RATIO_BONG_TAI = 30;
    private static final int RATIO_MO_CHI_SO_BONG_TAI = 40;
    private static final int RATIO_MO_CHI_SO_BI_TICH = 50;
    private static final int RATIO_LINH_THU = 95;
    private static final int RATIO_NANG_CAP = 45;
    private static final int RUBY_BONG_TAI = 10_000;
    private final Npc baHatMit;
    private final Npc onggianoel;
    private final Npc npsthiensu64;
    private final Npc lmht;

    private static CombineServiceNew i;

    public CombineServiceNew() {
        this.baHatMit = NpcManager.getNpc(ConstNpc.BA_HAT_MIT);
        this.onggianoel = NpcManager.getNpc(ConstNpc.ONG_GIA_NOEL);
        this.npsthiensu64 = NpcManager.getNpc(ConstNpc.NPC_64);
        this.lmht = NpcManager.getNpc(ConstNpc.THUCTINH);
    }

    public static CombineServiceNew gI() {
        if (i == null) {
            i = new CombineServiceNew();
        }
        return i;
    }

    /**
     * Mở tab đập đồ
     *
     * @param player
     * @param type kiểu đập đồ
     */
    public void openTabCombine(Player player, int type) {
        player.combineNew.setTypeCombine(type);
        Message msg;
        try {
            msg = new Message(-81);
            msg.writer().writeByte(OPEN_TAB_COMBINE);
            msg.writer().writeUTF(getTextInfoTabCombine(type));
            msg.writer().writeUTF(getTextTopTabCombine(type));
            if (player.iDMark.getNpcChose() != null) {
                msg.writer().writeShort(player.iDMark.getNpcChose().tempId);
            }
            player.sendMessage(msg);
            msg.cleanup();
        } catch (Exception e) {
        }
    }

    /**
     * Hiển thị thông tin đập đồ
     *
     * @param player
     */
    public void showInfoCombine(Player player, int[] index) {
        player.combineNew.clearItemCombine();
        if (index.length > 0) {
            for (int i = 0; i < index.length; i++) {
                player.combineNew.itemsCombine.add(player.inventory.itemsBag.get(index[i]));
            }
        }
        switch (player.combineNew.typeCombine) {

            case GIAM_DINH_SACH:
                if (player.combineNew.itemsCombine.size() == 2) {
                    Item sachTuyetKy = null;
                    Item buaGiamDinh = null;
                    for (Item item : player.combineNew.itemsCombine) {
                        if (issachTuyetKy(item)) {
                            sachTuyetKy = item;
                        } else if (item.template.id == 1554) {
                            buaGiamDinh = item;
                        }
                    }
                    if (sachTuyetKy != null && buaGiamDinh != null) {

                        String npcSay = "|1|" + sachTuyetKy.getName() + "\n";
                        npcSay += "|2|" + buaGiamDinh.getName() + " " + buaGiamDinh.quantity + "/1";
                        baHatMit.createOtherMenu(player, ConstNpc.MENU_START_COMBINE, npcSay,
                                "Giám định", "Từ chối");
                    } else {
                        Service.getInstance().sendThongBaoOK(player, "Cần Sách Tuyệt Kỹ và bùa giám định");
                        return;
                    }
                } else {
                    Service.getInstance().sendThongBaoOK(player, "Cần Sách Tuyệt Kỹ và bùa giám định");
                    return;
                }
                break;
            case TAY_SACH:
                if (player.combineNew.itemsCombine.size() == 1) {
                    Item sachTuyetKy = null;
                    for (Item item : player.combineNew.itemsCombine) {
                        if (issachTuyetKy(item)) {
                            sachTuyetKy = item;
                        }
                    }
                    if (sachTuyetKy != null) {
                        String npcSay = "|2|Tẩy Sách Tuyệt Kỹ";
                        baHatMit.createOtherMenu(player, ConstNpc.MENU_START_COMBINE, npcSay,
                                "Đồng ý", "Từ chối");
                    } else {
                        Service.getInstance().sendThongBaoOK(player, "Cần Sách Tuyệt Kỹ để tẩy");
                        return;
                    }
                } else {
                    Service.getInstance().sendThongBaoOK(player, "Cần Sách Tuyệt Kỹ để tẩy");
                    return;
                }
                break;

            case NANG_CAP_SACH_TUYET_KY:
                if (player.combineNew.itemsCombine.size() == 2) {
                    Item sachTuyetKy = null;
                    Item kimBamGiay = null;
                    for (Item item : player.combineNew.itemsCombine) {
                        if (issachTuyetKy(item) && (item.template.id == 1542 || item.template.id == 1544 || item.template.id == 1546)) {
                            sachTuyetKy = item;
                        } else if (item.template.id == 1553) {
                            kimBamGiay = item;
                        }
                    }
                    if (sachTuyetKy != null && kimBamGiay != null) {
                        String npcSay = "|2|Nâng cấp sách tuyệt kỹ\n";
                        npcSay += "Cần 10 Kìm bấm giấy\n"
                                + "Tỉ lệ thành công: 10%\n"
                                + "Nâng cấp thất bại sẽ mất 10 Kìm bấm giấy";
                        baHatMit.createOtherMenu(player, ConstNpc.MENU_START_COMBINE, npcSay,
                                "Nâng cấp", "Từ chối");
                    } else {
                        Service.getInstance().sendThongBaoOK(player, "Cần Sách Tuyệt Kỹ 1 và 10 Kìm bấm giấy.");
                        return;
                    }
                } else {
                    Service.getInstance().sendThongBaoOK(player, "Cần Sách Tuyệt Kỹ 1 và 10 Kìm bấm giấy.");
                    return;
                }
                break;
            case PHUC_HOI_SACH:
                if (player.combineNew.itemsCombine.size() == 1) {
                    Item sachTuyetKy = null;
                    for (Item item : player.combineNew.itemsCombine) {
                        if (issachTuyetKy(item)) {
                            sachTuyetKy = item;
                        }
                    }
                    if (sachTuyetKy != null) {
                        String npcSay = "|2|Phục hồi " + sachTuyetKy.getName() + "\n"
                                + "Cần 10 cuốn sách cũ\n"
                                + "Phí phục hồi 10 triệu vàng";
                        baHatMit.createOtherMenu(player, ConstNpc.MENU_START_COMBINE, npcSay,
                                "Đồng ý", "Từ chối");
                    } else {
                        Service.getInstance().sendThongBaoOK(player, "Không tìm thấy vật phẩm");
                        return;
                    }
                } else {
                    Service.getInstance().sendThongBaoOK(player, "Không tìm thấy vật phẩm");
                    return;
                }
                break;
            case PHAN_RA_SACH:
                if (player.combineNew.itemsCombine.size() == 1) {
                    Item sachTuyetKy = null;
                    for (Item item : player.combineNew.itemsCombine) {
                        if (issachTuyetKy(item)) {
                            sachTuyetKy = item;
                        }
                    }
                    if (sachTuyetKy != null) {
                        String npcSay = "|2|Phân rã sách\n"
                                + "Nhận lại 5 cuốn sách cũ\n"
                                + "Phí rã 10 triệu vàng";
                        baHatMit.createOtherMenu(player, ConstNpc.MENU_START_COMBINE, npcSay,
                                "Đồng ý", "Từ chối");
                    } else {
                        Service.getInstance().sendThongBaoOK(player, "Không tìm thấy vật phẩm");
                        return;
                    }
                } else {
                    Service.getInstance().sendThongBaoOK(player, "Không tìm thấy vật phẩm");
                    return;
                }
                break;

            case THUC_TINH_DT:
                if (player.combineNew.itemsCombine.size() == 3) {
                    Item dathuctinh = null;
                    Item ngocrong = null;
                    Item tv = null;
                    Item ngocrongsp = null;
                    for (Item item : player.combineNew.itemsCombine) {
                        if (item.template.id == 16) {
                            ngocrong = item;
                        } else if (item.template.id == 14) {
                            ngocrongsp = item;
                        } else if (item.template.id == 1421) {
                            dathuctinh = item;
                        } else if (item.template.id == 457) {
                            tv = item;
                        }
                    }
                    if (ngocrongsp != null && ngocrongsp.quantity >= 3 && dathuctinh != null && dathuctinh.quantity >= 30
                            && tv != null && tv.quantity >= 3) {
                        if (player.nPoint.hpg >= 680000 && player.nPoint.mpg >= 680000 && player.nPoint.dameg >= 38000) {
                            this.lmht.createOtherMenu(player, ConstNpc.IGNORE_MENU,
                                    "Bạn đã đạt cấp độ thức tỉnh tối đa tối đa", "Đóng");
                            return;
                        }
                        if (player.nPoint.dameg >= 32000 && player.nPoint.hpg >= 600000
                                && player.nPoint.mpg >= 600000 && player.nPoint.power >= 80000000000L) {
                            String npcSay = "|7|[ THỨC TỈNH BẢN THÂN ]"
                                    + "\n|5|HP: " + player.nPoint.hpg
                                    + "\nKI: " + player.nPoint.mpg
                                    + "\nSD: " + player.nPoint.dameg
                                    + "\n|7|Tỉ lệ thành công: "
                                    + (player.nPoint.hpg >= 600000 && player.nPoint.hpg < 620000
                                    && player.nPoint.mpg >= 600000 && player.nPoint.mpg < 620000
                                    && player.nPoint.dameg >= 32000 && player.nPoint.dameg < 34000 ? "50%"
                                            : player.nPoint.hpg >= 620000 && player.nPoint.hpg < 640000
                                            && player.nPoint.mpg >= 620000 && player.nPoint.mpg < 640000
                                            && player.nPoint.dameg >= 34000 && player.nPoint.dameg < 36000 ? "30%" : "10%") + "\n";
                            this.lmht.createOtherMenu(player, ConstNpc.MENU_START_COMBINE, npcSay,
                                    "Nâng X1\nCần 100\nHồng Ngọc", "Nâng X10\nCần 1.000\nHồng Ngọc", "Nâng X100\nCần 10.000\nHồng Ngọc");
                        } else {
                            this.lmht.createOtherMenu(player, ConstNpc.IGNORE_MENU,
                                    "|7|Ngươi chưa đạt đủ điều kiện để thức tỉnh\n"
                                    + "Yêu cầu : Max chỉ số HP, KI, SD và sức mạnh đạt 80Tỷ trở lên", "Đóng");
                        }
                    } else if (ngocrong != null && ngocrong.quantity >= 3
                            && dathuctinh != null && dathuctinh.quantity >= 15
                            && tv != null && tv.quantity >= 1) {
                        if (player.pet.nPoint.dameg >= 32000 && player.pet.nPoint.hpg >= 600000
                                && player.pet.nPoint.mpg >= 600000 && player.pet.nPoint.power >= 80000000000L) {
                            String tsSay = "|7|[ THỨC TỈNH ĐỆ TỬ ]\n" + player.pet.name.substring(1)
                                    + "\n|5|Cấp bậc : " + player.pet.getNameThuctinh(player.pet.thuctinh)
                                    + "\nHP: " + (player.pet.nPoint.hpg >= 680000 ? Util.format(player.pet.nPoint.hpg)
                                            : Util.format(player.pet.nPoint.hpg) + " Cấp Sau: " + Util.format(player.pet.nPoint.hpg + 200))
                                    + "\nKI: " + (player.pet.nPoint.mpg >= 680000 ? Util.format(player.pet.nPoint.mpg)
                                            : Util.format(player.pet.nPoint.mpg) + " Cấp Sau: " + Util.format(player.pet.nPoint.mpg + 200))
                                    + "\nSD: " + (player.pet.nPoint.dameg >= 38000 ? Util.format(player.pet.nPoint.dameg)
                                            : Util.format(player.pet.nPoint.dameg) + " Cấp Sau: " + Util.format(player.pet.nPoint.dameg + 100))
                                    + "\n|7|Tỉ lệ thành công: "
                                    + (player.pet.nPoint.hpg >= 600000 && player.pet.nPoint.hpg < 620000
                                    && player.pet.nPoint.mpg >= 600000 && player.pet.nPoint.mpg < 620000
                                    && player.pet.nPoint.dameg >= 32000 && player.pet.nPoint.dameg < 34000 ? "50%"
                                            : player.pet.nPoint.hpg >= 620000 && player.pet.nPoint.hpg < 640000
                                            && player.pet.nPoint.mpg >= 620000 && player.pet.nPoint.mpg < 640000
                                            && player.pet.nPoint.dameg >= 34000 && player.pet.nPoint.dameg < 36000 ? "30%" : "10%") + "\n";
                            this.lmht.createOtherMenu(player, ConstNpc.MENU_START_COMBINE, tsSay,
                                    "Nâng X1\nCần 100\nHồng Ngọc", "Nâng X10\nCần 1.000\nHồng Ngọc", "Nâng X100\nCần 10.000\nHồng Ngọc");
                        } else {
                            this.lmht.createOtherMenu(player, ConstNpc.IGNORE_MENU,
                                    "|7|Đệ tử ngươi chưa đạt đủ điều kiện để thức tỉnh\n"
                                    + "Yêu cầu : Max chỉ số HP, KI, SD và sức mạnh đạt 80Tỷ trở lên", "Đóng");
                        }
                    } else {
                        this.lmht.createOtherMenu(player, ConstNpc.IGNORE_MENU,
                                "Đối với đệ tử: Cần 30 Đá Thức Tỉnh, 3 viên ngọc rồng 3s và 1 thỏi vàng"
                                + "\nĐối với sư phụ: Cần 50 Đá Thức Tỉnh, 3 viên ngọc rồng 1s và 3 thỏi vàng", "Đóng");
                    }
                } else {
                    this.lmht.createOtherMenu(player, ConstNpc.IGNORE_MENU,
                            "Đối với đệ tử: Cần 30 Đá Thức Tỉnh, 3 viên ngọc rồng 3s và 1 thỏi vàng"
                            + "\nĐối với sư phụ: Cần 50 Đá Thức Tỉnh, 3 viên ngọc rồng 1s và 3 thỏi vàng", "Đóng");
                }
                break;

            case MO_CHI_SO_CAI_TRANG:
                if (player.combineNew.itemsCombine.size() == 0) {
                    this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU,
                            "Hãy đưa em cái trang chưa kích hoạt chỉ số !",
                            "Đóng");
                    return;
                }

                if (player.combineNew.itemsCombine.size() == 2) {
                    if (player.combineNew.itemsCombine.stream().filter(
                            item -> item.isNotNullItem() && (item.template.type == 5))
                            .count() < 1) {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Thiếu cải trang", "Đóng");
                        return;
                    }
                    if (player.combineNew.itemsCombine.stream()
                            .filter(item -> item.isNotNullItem() && item.template.id == 674)
                            .count() < 1) {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Thiếu lồng đèn", "Đóng");
                        return;
                    }

                    String npcSay = "Anh có muốn mở chỉ số cải trang!";

                    this.baHatMit.createOtherMenu(player, ConstNpc.MENU_START_COMBINE,
                            npcSay, "Nâng cấp", "Từ chối");
                } else {
                    if (player.combineNew.itemsCombine.size() > 2) {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Nguyên liệu không phù hợp",
                                "Đóng");
                        return;
                    }
                    this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU,
                            "Còn thiếu nguyên liệu để nâng cấp hãy quay lại sau", "Đóng");
                }
                break;

// ---------------------------- ĐẬP SÉT KÍCH HOẠT ĐỒ THẦN -------------------------------------------------            
            case DAP_SET_KICH_HOAT:
                if (player.combineNew.itemsCombine.size() == 1 || player.combineNew.itemsCombine.size() == 2) {
                    Item dhd = null, dtl = null;
                    for (Item item : player.combineNew.itemsCombine) {
                        if (item.isNotNullItem()) {
                            if (item.template.id >= 650 && item.template.id <= 662) {
                                dhd = item;
                            } else if (item.template.id >= 555 && item.template.id <= 567) {
                                dtl = item;
                            }
                        }
                    }
                    if (dhd != null) {
                        String npcSay = "|6|" + dhd.template.name + "\n";
                        for (Item.ItemOption io : dhd.itemOptions) {
                            npcSay += "|2|" + io.getOptionString() + "\n";
                        }
                        if (dtl != null) {
                            npcSay += "|6|" + dtl.template.name + "\n";
                            for (Item.ItemOption io : dtl.itemOptions) {
                                npcSay += "|2|" + io.getOptionString() + "\n";
                            }
                        }
                        npcSay += "Ngươi có muốn chuyển hóa thành\n";
                        npcSay += "|1|" + getNameItemC0(dhd.template.gender, dhd.template.type)
                                + " (ngẫu nhiên kích hoạt)\n|7|Tỉ lệ thành công " + (dtl != null ? "100%" : "40%") + "\n|2|Cần "
                                + Util.numberToMoney(COST_DAP_DO_KICH_HOAT) + " vàng";
                        if (player.inventory.gold >= COST_DAP_DO_KICH_HOAT) {
                            this.baHatMit.createOtherMenu(player, ConstNpc.MENU_START_COMBINE, npcSay, "Cần " + Util.numberToMoney(COST_DAP_DO_KICH_HOAT) + " vàng");
                        } else {
                            this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, npcSay, "Còn thiếu\n"
                                    + Util.numberToMoney(player.inventory.gold - COST_DAP_DO_KICH_HOAT) + " vàng");
                        }
                    } else {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Ta cần 1 món đồ hủy diệt của ngươi để có thể chuyển hóa 1", "Đóng");
                    }
                } else {
                    this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Ta cần 1 món đồ hủy diệt của ngươi để có thể chuyển hóa 2", "Đóng");
                }
                break;

// -----------------------------------------------------------------------------                  
            case DAP_SET_KICH_HOAT_HD:
                if (player.combineNew.itemsCombine.size() == 2) {
                    Item dhd = null, dtl = null;
                    for (Item item : player.combineNew.itemsCombine) {
                        if (item.isNotNullItem()) {
                            if (item.template.id == 674) {
                                dtl = item;
                            } else if (item.template.id >= 650 && item.template.id <= 662) {
                                dhd = item;
                            }
                        }
                    }
                    if (dhd.isSKH() && dhd != null && dtl != null) {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Ta cần Trang Bị Hủy Diệt chưa có SKH và 150 viên Đá Ngũ Sắc", "Đóng");
                    } else if (dhd != null && dtl != null) {
                        String npcSay = "|6|" + dhd.template.name + "\n";
                        for (Item.ItemOption io : dhd.itemOptions) {
                            npcSay += "|2|" + io.getOptionString() + "\n";
                        }
                        npcSay += "Ngươi có muốn chuyển hóa thành\n";
                        npcSay += "|1|" + getNameItemC1(dhd.template.gender, dhd.template.type)
                                + " (ngẫu nhiên Set Kích Hoạt)\n|7|Tỉ lệ thành công " + (dtl != null ? "100%" : "40%") + "\n|2|Cần "
                                + Util.numberToMoney(COST_DAP_DO_KICH_HOAT) + " Vàng" + Util.numberToMoney(RUBY_DAP_DO_KICH_HOAT) + " Hồng Ngọc" + Util.numberToMoney(GEM_DAP_DO_KICH_HOAT) + " Ngọc Xanh";
                        if (player.inventory.gold >= COST_DAP_DO_KICH_HOAT) {
                            this.baHatMit.createOtherMenu(player, ConstNpc.MENU_START_COMBINE, npcSay, "Cần " + Util.numberToMoney(COST_DAP_DO_KICH_HOAT) + " Vàng" + Util.numberToMoney(RUBY_DAP_DO_KICH_HOAT) + " Hồng Ngọc" + Util.numberToMoney(GEM_DAP_DO_KICH_HOAT) + " Ngọc Xanh");
                        } else {
                            this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, npcSay, "Chuẩn bị đủ tiền rồi hãy gặp ta!!!");
                        }
                    } else {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Ta cần Trang Bị Hủy Diệt và 150 viên Đá Ngũ Sắc", "Đóng");
                    }
                }
                break;
            case DAP_SET_KICH_HOAT_TS:
                if (player.combineNew.itemsCombine.size() == 2) {
                    Item dhd = null, dtl = null;
                    for (Item item : player.combineNew.itemsCombine) {
                        if (item.isNotNullItem()) {
                            if (item.template.id == 674) {
                                dtl = item;
                            } else if (item.template.id >= 1048 && item.template.id <= 1062) {
                                dhd = item;
                            }
                        }
                    }
                    if (dhd.isSKH() && dhd != null && dtl != null) {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Ta cần Trang Bị Thiên Sứ chưa có SKH và 200 viên Đá Ngũ Sắc", "Đóng");
                    } else if (dhd != null && dtl != null) {
                        String npcSay = "|6|" + dhd.template.name + "\n";
                        for (Item.ItemOption io : dhd.itemOptions) {
                            npcSay += "|2|" + io.getOptionString() + "\n";
                        }
                        npcSay += "Ngươi có muốn chuyển hóa thành\n";
                        npcSay += "|1|" + getNameItemC1(dhd.template.gender, dhd.template.type)
                                + " (ngẫu nhiên Set Kích Hoạt)\n|7|Tỉ lệ thành công " + (dtl != null ? "100%" : "40%") + "\n|2|Cần "
                                + Util.numberToMoney(COST_DAP_DO_KICH_HOAT) + " Vàng" + Util.numberToMoney(RUBY_DAP_DO_KICH_HOAT) + " Hồng Ngọc" + Util.numberToMoney(GEM_DAP_DO_KICH_HOAT) + " Ngọc Xanh";
                        if (player.inventory.gold >= COST_DAP_DO_KICH_HOAT) {
                            this.baHatMit.createOtherMenu(player, ConstNpc.MENU_START_COMBINE, npcSay, "Cần " + Util.numberToMoney(COST_DAP_DO_KICH_HOAT) + " Vàng" + Util.numberToMoney(RUBY_DAP_DO_KICH_HOAT) + " Hồng Ngọc" + Util.numberToMoney(GEM_DAP_DO_KICH_HOAT) + " Ngọc Xanh");
                        } else {
                            this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, npcSay, "Chuẩn bị đủ tiền rồi hãy gặp ta!!!");
                        }
                    } else {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Ta cần Trang Bị Thiên Sứ và 200 viên Đá Ngũ Sắc", "Đóng");
                    }
                }
                break;
            case NANG_HUY_DIET_LEN_SKH_VIP:
                if (player.combineNew.itemsCombine.size() == 0) {
                    this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Hãy đưa ta 3 món huỷ diệt....", "Đóng");
                    return;
                }
                if (player.combineNew.itemsCombine.size() == 3) {
                    if (player.combineNew.itemsCombine.stream().filter(item -> item.isNotNullItem() && item.isDHD()).count() != 3) {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Thiếu đồ huỷ điệt rồi", "Đóng");
                        return;
                    }
                    Item item1 = player.combineNew.itemsCombine.get(0);
                    Item item2 = player.combineNew.itemsCombine.get(1);
                    Item item3 = player.combineNew.itemsCombine.get(2);

                    String npcSay = "|2|Con có muốn đổi các món nguyên liệu ?\n|7|"
                            + "Và nhận được " + player.combineNew.itemsCombine.stream().filter(Item::isDHD).findFirst().get().typeName() + " kích hoạt VIP tương ứng\n"
                            + "|1|Cần " + Util.numberToMoney(COST) + " vàng";

                    if (player.inventory.gold < COST) {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Hết tiền rồi\nẢo ít thôi con", "Đóng");
                        return;
                    }
                    this.baHatMit.createOtherMenu(player, ConstNpc.MENU_START_COMBINE,
                            npcSay, "Nâng cấp\n" + Util.numberToMoney(500000000) + " vàng", "Từ chối");
                } else {
                    if (player.combineNew.itemsCombine.size() > 4) {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Nguyên liệu không phù hợp", "Đóng");
                        return;
                    }
                    this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Còn thiếu nguyên liệu để nâng cấp hãy quay lại sau", "Đóng");
                }
                break;
            case TAY_SKH_TRANG_BI:
                if (player.combineNew.itemsCombine.size() == 2) {
                    Item dhd = null,
                            buatay = null;
                    for (Item item : player.combineNew.itemsCombine) {
                        if (item.isNotNullItem()) {
                            if (item.template.id == 674) {
                                buatay = item;
                            } else if (item.template.id >= 650 && item.template.id <= 662
                                    || item.template.id >= 1048 && item.template.id <= 1062
                                    || item.template.id >= 555 && item.template.id <= 567) {
                                dhd = item;
                            }
                        }
                    }

                    if (dhd == null || buatay == null) {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Ta cần Trang Bị SKH và 1 Đá Ngũ Sắc", "Đóng");
                        return;
                    }

                    int level = 0;
                    int level2 = 0;
                    int level3 = 0;
                    Item.ItemOption optionLevel = null;
                    Item.ItemOption optionLevel2 = null;
                    Item.ItemOption optionLevel3 = null;
                    for (Item.ItemOption io : dhd.itemOptions) {
                        if (io.optionTemplate.id >= 127 && io.optionTemplate.id <= 135) {
                            level = io.param;
                            optionLevel = io;
                            break;
                        }
                    }
                    for (Item.ItemOption io : dhd.itemOptions) {
                        if (io.optionTemplate.id >= 136 && io.optionTemplate.id <= 144) {
                            level2 = io.param;
                            optionLevel2 = io;
                            break;
                        }
                    }
                    for (Item.ItemOption io : dhd.itemOptions) {
                        if (io.optionTemplate.id == 30) {
                            level3 = io.param;
                            optionLevel3 = io;
                            break;
                        }
                    }

                    if (dhd == null || buatay == null) {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Ta cần Trang Bị Kích Hoạt và 1 Bùa Tẩy Pháp Sư", "Đóng");
                    } else if (dhd.isSKH() && dhd != null && buatay != null) {
                        String npcSay = "|6|" + dhd.template.name + "\n";
                        for (Item.ItemOption io : dhd.itemOptions) {
                            npcSay += "|2|" + io.getOptionString() + "\n";
                        }
                        npcSay += "Ngươi có muốn tẩy SKH trang bị này không?\n";
                        if (player.inventory.gold >= 0) {
                            this.baHatMit.createOtherMenu(player, ConstNpc.MENU_START_COMBINE, npcSay, "Tẩy SKH");
                        } else {
                            this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, npcSay, "Chuẩn bị đủ tiền rồi hãy gặp ta!!!");
                        }
                    } else {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Ta cần Trang Bị SKH và 1 viên Đá Ngũ Sắc", "Đóng");
                    }
                } else {
                    this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Ta cần Trang Bị SKH và 1 viên Đá Ngũ Sắc", "Đóng");
                }
                break;

            case KHAC_CHI_SO_DA:
                if (player.combineNew.itemsCombine.size() == 2) {
                    Item ngocboi1 = null, DaKhac = null;

                    for (Item item : player.combineNew.itemsCombine) {
                        if (item.isNotNullItem()) {
                            if (item.template.id == 1251) {
                                DaKhac = item;
                            } else if (item.template.id == 1248) {
                                ngocboi1 = item;
                            }
                        }
                    }
                    int level1_1 = 0;
                    int level1_2 = 0;
                    int level1_3 = 0;
                    int level1_4 = 0;
                    int level1_72 = 0;
                    int level1_102 = 0;
                    int leve2_213 = 0;
                    int leve2_217 = 0;
                    Item.ItemOption optionLevel = null;
                    Item.ItemOption optionLevel_102 = null;
                    Item.ItemOption optionLeve2_213 = null;
                    Item.ItemOption optionLeve2_217 = null;

                    for (Item.ItemOption io : DaKhac.itemOptions) {
                        if (io.optionTemplate.id == 213) { // Đã Điêu Khắc Chỉ Số
                            leve2_213 = io.param;
                            optionLeve2_213 = io;
                            break;
                        }
                    }
                    for (Item.ItemOption io : DaKhac.itemOptions) {
                        if (io.optionTemplate.id == 217) { // Đá Điêu Khắc Cấp
                            leve2_217 = io.param; // Số Cấp
                            optionLeve2_217 = io; // ID Option
                            break;
                        }
                    }

                    for (Item.ItemOption io : ngocboi1.itemOptions) {
                        if (io.optionTemplate.id == 72) {
                            level1_72 = io.param;
                            optionLevel = io;
                            break;
                        }
                    }
                    for (Item.ItemOption io : ngocboi1.itemOptions) {
                        if (io.optionTemplate.id == 102) {
                            level1_102 = io.param;
                            optionLevel_102 = io;
                            break;
                        }
                    }
                    for (Item.ItemOption io : ngocboi1.itemOptions) {
                        if (io.optionTemplate.id == 50) {
                            level1_1 = io.param;
                            break;
                        }
                    }
                    for (Item.ItemOption io : ngocboi1.itemOptions) {
                        if (io.optionTemplate.id == 77) {
                            level1_2 = io.param;
                            break;
                        }
                    }
                    for (Item.ItemOption io : ngocboi1.itemOptions) {
                        if (io.optionTemplate.id == 103) {
                            level1_3 = io.param;
                            break;
                        }
                    }
                    for (Item.ItemOption io : ngocboi1.itemOptions) {
                        if (io.optionTemplate.id == 5) {
                            level1_4 = io.param;
                            break;
                        }
                    }

                    if (ngocboi1 == null || DaKhac == null) {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Ta cần Ngọc Bội và 1 Đá Chưa Khắc Chỉ Số", "Đóng");
                    }
                    if (player.inventory.ruby < 100000) {
                        Service.getInstance().sendThongBao(player, "Chuẩn bị đủ 100K Hồng Ngọc hãy đến tìm ta");
                        return;
                    } else if (level1_72 == 0 && ngocboi1 != null && DaKhac != null && optionLeve2_213 == null && optionLevel_102 == null) {
                        String npcSay = "|6|" + ngocboi1.template.name + "\n";
                        for (Item.ItemOption io : ngocboi1.itemOptions) {
                            npcSay += "|2|" + io.getOptionString() + "\n";
                        }
                        npcSay += "Ngươi có muốn Khắc Chỉ Số vào Đá không?\n";
                        if (player.inventory.ruby >= 100000) {
                            this.baHatMit.createOtherMenu(player, ConstNpc.MENU_START_COMBINE, npcSay, "Điêu Khắc");
                        } else {
                            this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, npcSay, "Chuẩn bị đủ tiền rồi hãy gặp ta!!!");
                        }
                    } else {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Ta cần Ngọc Bội Zin và 1 Đá Chưa Điêu Khắc Chỉ Số", "Đóng");
                    }
                }
                break;
            case KHAC_CHI_SO_NGOC_BOI:
                if (player.combineNew.itemsCombine.size() == 2) {
                    Item ngocboi1 = null, DaKhac = null;

                    for (Item item : player.combineNew.itemsCombine) {
                        if (item.isNotNullItem()) {
                            if (item.template.id == 1251) {
                                DaKhac = item;
                            } else if (item.template.id == 1248
                                    || item.template.id == 1253
                                    || item.template.id == 1254
                                    || item.template.id == 1255
                                    || item.template.id == 1256
                                    || item.template.id == 1257) {
                                ngocboi1 = item;
                            }
                        }
                    }
                    int level1_1 = 0;
                    int level1_2 = 0;
                    int level1_3 = 0;
                    int level1_4 = 0;
                    int level2_1 = 0;
                    int level2_2 = 0;
                    int level2_3 = 0;
                    int level2_4 = 0;
                    int level3_1 = 0;
                    int level3_2 = 0;
                    int level3_3 = 0;
                    int level3_4 = 0;
                    int level1_72 = 0;
                    int leve2_213 = 0;
                    int leve2_217 = 0;
                    Item.ItemOption optionLevel = null;
                    Item.ItemOption optionLeve2_213 = null;
                    Item.ItemOption optionLeve2_217 = null;

                    for (Item.ItemOption io : DaKhac.itemOptions) {
                        if (io.optionTemplate.id == 213) { // Đã Điêu Khắc Chỉ Số
                            leve2_213 = io.param;
                            optionLeve2_213 = io;
                            break;
                        }
                    }
                    for (Item.ItemOption io : DaKhac.itemOptions) {
                        if (io.optionTemplate.id == 217) { // Đá Điêu Khắc Cấp
                            leve2_217 = io.param; // Số Cấp
                            optionLeve2_217 = io; // ID Option
                            break;
                        }
                    }

                    for (Item.ItemOption io : ngocboi1.itemOptions) {
                        if (io.optionTemplate.id == 72) {
                            level1_72 = io.param;
                            optionLevel = io;
                            break;
                        }
                    }
                    for (Item.ItemOption io : ngocboi1.itemOptions) {
                        if (io.optionTemplate.id == 50) {
                            level1_1 = io.param;
                            break;
                        }
                    }
                    for (Item.ItemOption io : ngocboi1.itemOptions) {
                        if (io.optionTemplate.id == 77) {
                            level1_2 = io.param;
                            break;
                        }
                    }
                    for (Item.ItemOption io : ngocboi1.itemOptions) {
                        if (io.optionTemplate.id == 103) {
                            level1_3 = io.param;
                            break;
                        }
                    }
                    for (Item.ItemOption io : ngocboi1.itemOptions) {
                        if (io.optionTemplate.id == 5) {
                            level1_4 = io.param;
                            break;
                        }
                    }
                    for (Item.ItemOption io : DaKhac.itemOptions) {
                        if (io.optionTemplate.id == 50) {
                            level2_1 = io.param;
                            break;
                        }
                    }
                    for (Item.ItemOption io : DaKhac.itemOptions) {
                        if (io.optionTemplate.id == 77) {
                            level2_2 = io.param;
                            break;
                        }
                    }
                    for (Item.ItemOption io : DaKhac.itemOptions) {
                        if (io.optionTemplate.id == 103) {
                            level2_3 = io.param;
                            break;
                        }
                    }
                    for (Item.ItemOption io : DaKhac.itemOptions) {
                        if (io.optionTemplate.id == 5) {
                            level2_4 = io.param;
                            break;
                        }
                    }

                    if (ngocboi1 == null || DaKhac == null) {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Ta cần Ngọc Bội và 1 Đá Khắc Chỉ Số", "Đóng");
                    }
                    if (player.inventory.ruby < 100000) {
                        Service.getInstance().sendThongBao(player, "Chuẩn bị đủ 100K Hồng Ngọc hãy đến tìm ta");
                        return;
                    } else if (ngocboi1 != null && DaKhac != null && optionLeve2_213 != null) {
                        String npcSay = "|6|" + DaKhac.template.name + "\n";
                        for (Item.ItemOption io : DaKhac.itemOptions) {
                            npcSay += "|2|" + io.getOptionString() + "\n";
                        }
                        npcSay += "Ngươi có muốn Khắc Chỉ Số vào Ngọc Bội không?\n";
                        if (player.inventory.gold >= 0) {
                            this.baHatMit.createOtherMenu(player, ConstNpc.MENU_START_COMBINE, npcSay, "Điêu Khắc\n Ngọc Bội");
                        } else {
                            this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, npcSay, "Chuẩn bị đủ tiền rồi hãy gặp ta!!!");
                        }
                    } else {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Ta cần Ngọc Bội và 1 Đá Điêu Khắc Chỉ Số", "Đóng");
                    }
                }
                break;

            case TIEN_HOA_NGOC_BOI:
                if (player.combineNew.itemsCombine.size() == 2) {
                    Item ngocboi1 = null, DaKhac = null;

                    for (Item item : player.combineNew.itemsCombine) {
                        if (item.isNotNullItem()) {
                            if (item.template.id == 1258) {
                                DaKhac = item;
                            } else if (item.template.id == 1248
                                    || item.template.id == 1253
                                    || item.template.id == 1254
                                    || item.template.id == 1255
                                    || item.template.id == 1256
                                    || item.template.id == 1257) {
                                ngocboi1 = item;
                            }
                        }
                    }
                    int level1_1 = 0;
                    int level1_2 = 0;
                    int level1_3 = 0;
                    int level1_4 = 0;
                    int level1_72 = 0;
                    Item.ItemOption optionLevel_72 = null;

                    for (Item.ItemOption io : ngocboi1.itemOptions) {
                        if (io.optionTemplate.id == 72) {
                            level1_72 = io.param;
                            optionLevel_72 = io;
                            break;
                        }
                    }
                    for (Item.ItemOption io : ngocboi1.itemOptions) {
                        if (io.optionTemplate.id == 50) {
                            level1_1 = io.param;
                            break;
                        }
                    }
                    for (Item.ItemOption io : ngocboi1.itemOptions) {
                        if (io.optionTemplate.id == 77) {
                            level1_2 = io.param;
                            break;
                        }
                    }
                    for (Item.ItemOption io : ngocboi1.itemOptions) {
                        if (io.optionTemplate.id == 103) {
                            level1_3 = io.param;
                            break;
                        }
                    }
                    for (Item.ItemOption io : ngocboi1.itemOptions) {
                        if (io.optionTemplate.id == 5) {
                            level1_4 = io.param;
                            break;
                        }
                    }

                    if (ngocboi1 == null || DaKhac == null) {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Ta cần Ngọc Bội và 1 Đá Tiến Hóa Ngọc Bội", "Đóng");
                    }
                    if (player.inventory.ruby < 500000 || player.inventory.gold < 50_000_000_000L) {
                        Service.getInstance().sendThongBao(player, "Chuẩn bị đủ 500K Hồng Ngọc và 50 Tỷ Vàng hãy đến tìm ta");
                        return;
                    } else if (ngocboi1 != null && DaKhac != null && level1_72 == 10) {
                        String npcSay = "|6|" + ngocboi1.template.name + "\n";
                        for (Item.ItemOption io : ngocboi1.itemOptions) {
                            npcSay += "|2|" + io.getOptionString() + "\n";
                        }
                        npcSay += "Ngươi có muốn Tiến Hóa Ngọc Bội không?\n";
                        if (player.inventory.gold >= 50_000_000_000L && player.inventory.ruby >= 500000) {
                            this.baHatMit.createOtherMenu(player, ConstNpc.MENU_START_COMBINE, npcSay, "Tiến Hóa\n Ngọc Bội");
                        } else {
                            this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, npcSay, "Chuẩn bị đủ tiền rồi hãy gặp ta!!!");
                        }
                    } else {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Ta cần Ngọc Bội + 10 và 1 Đá Tiến Hóa Ngọc Bội", "Đóng");
                    }
                }
                break;
            case THANG_CAP_TRANG_BI:
                if (player.combineNew.itemsCombine.size() == 3) {
                    Item Trangbi = null, DaBV = null, LuaThan = null;

                    for (Item item : player.combineNew.itemsCombine) {
                        if (item.isNotNullItem()) {
                            if (item.template.type == 0
                                    || item.template.type == 1
                                    || item.template.type == 2
                                    || item.template.type == 3
                                    || item.template.type == 4) {
                                Trangbi = item;
                            } else if (item.template.id == 987) {
                                DaBV = item;
                            } else if (item.template.id == 1250) {
                                LuaThan = item;
                            }
                        }
                    }
                    int level_102 = 0;
                    int level_216 = 0;
                    int level_107 = 0;
                    Item.ItemOption optionLevel_102 = null;
                    Item.ItemOption optionLevel_216 = null;
                    Item.ItemOption optionLevel_107 = null;

                    for (Item.ItemOption io : Trangbi.itemOptions) {
                        if (io.optionTemplate.id == 102) { // Số Sao Pha Lê
                            level_102 = io.param;
                            optionLevel_102 = io;
                            break;
                        }
                    }

                    for (Item.ItemOption io : Trangbi.itemOptions) {
                        if (io.optionTemplate.id == 216) { // Đã Thăng Cấp Mấy Lần
                            level_216 = io.param;
                            optionLevel_216 = io;
                            break;
                        }
                    }
                    for (Item.ItemOption io : Trangbi.itemOptions) {
                        if (io.optionTemplate.id == 107) {
                            level_107 = io.param;
                            optionLevel_107 = io;
                            break;
                        }
                    }

                    if (Trangbi == null || DaBV == null || LuaThan == null) {
                        this.onggianoel.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Ta cần Trang Bị Thăng Cấp, Đá Bảo Vệ và Lửa Thần", "Đóng");
                    }

                    if (player.inventory.ruby < 100000) {
                        Service.getInstance().sendThongBao(player, "Chuẩn bị đủ 100K Hồng Ngọc hãy đến tìm ta");
                        return;
                    } else if (Trangbi != null
                            && DaBV != null
                            && LuaThan != null
                            && level_102 == 16) {
                        String npcSay = "|6|" + Trangbi.template.name + "\n";
                        for (Item.ItemOption io : Trangbi.itemOptions) {
                            npcSay += "|2|" + io.getOptionString() + "\n";
                        }
                        npcSay += "Ngươi có muốn Thăng Cấp Trang Bị không?";
                        if (player.inventory.ruby >= 100000) {
                            this.onggianoel.createOtherMenu(player, ConstNpc.MENU_START_COMBINE, npcSay, "Thăng Cấp\n Trang Bị");
                        } else {
                            this.onggianoel.createOtherMenu(player, ConstNpc.IGNORE_MENU, npcSay, "Chuẩn bị đủ tiền rồi hãy gặp ta!!!");
                        }
                    } else {
                        this.onggianoel.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Ta cần Trang Bị Pha Lê Hóa 16 Sao", "Đóng");
                    }
                }
                break;
            case EP_SAO_TRANG_BI:
                if (player.combineNew.itemsCombine.size() == 2) {
                    Item trangBi = null;
                    Item daPhaLe = null;
                    for (Item item : player.combineNew.itemsCombine) {
                        if (isTrangBiEpPhaLeHoa(item)) {
                            trangBi = item;
                        } else if (isDaPhaLe(item)) {
                            daPhaLe = item;
                        }
                    }
                    int star = 0; //sao pha lê đã ép
                    int starEmpty = 0; //lỗ sao pha lê                    

                    if (trangBi != null && daPhaLe != null) {

                        for (Item.ItemOption io : trangBi.itemOptions) {
                            if (io.optionTemplate.id == 102) {
                                star = io.param;
                            } else if (io.optionTemplate.id == 107) {
                                starEmpty = io.param;
                            }
                        }
                        if (star < starEmpty) {
                            player.combineNew.gemCombine = getGemEpSao(star);
                            String npcSay = trangBi.template.name + "\n|2|";
                            for (Item.ItemOption io : trangBi.itemOptions) {
                                if (io.optionTemplate.id != 102) {
                                    npcSay += io.getOptionString() + "\n";
                                }
                            }
                            if (daPhaLe.template.type == 30) {
                                for (Item.ItemOption io : daPhaLe.itemOptions) {
                                    npcSay += "|7|" + io.getOptionString() + "\n";
                                }
                            } else {
                                npcSay += "|7|" + ItemService.gI().getItemOptionTemplate(getOptionDaPhaLe(daPhaLe)).name.replaceAll("#", getParamDaPhaLe(daPhaLe) + "") + "\n";
                            }
                            npcSay += "|1|Cần " + Util.numberToMoney(player.combineNew.gemCombine) + " ngọc";
                            baHatMit.createOtherMenu(player, ConstNpc.MENU_START_COMBINE, npcSay,
                                    "Nâng cấp\ncần " + player.combineNew.gemCombine + " ngọc");

                        } else {
                            this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU,
                                    "Cần 1 trang bị có lỗ sao pha lê và 1 loại đá pha lê để ép vào", "Đóng");
                        }
                    } else {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU,
                                "Cần 1 trang bị có lỗ sao pha lê và 1 loại đá pha lê để ép vào", "Đóng");
                    }
                } else {
                    this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU,
                            "Cần 1 trang bị có lỗ sao pha lê và 1 loại đá pha lê để ép vào", "Đóng");
                }
                break;

            case EP_DA_DANH_HIEU:
                if (player.combineNew.itemsCombine.size() == 2) {
                    Item DanhHieu = null;
                    Item DaPhaLe = null;
                    for (Item item : player.combineNew.itemsCombine) {
                        if (isDanhHieuPhaLeHoa(item)) {
                            DanhHieu = item;
                        } else if (isDaPhaLe100(item)) {
                            DaPhaLe = item;
                        }
                    }
                    int star = 0; //sao pha lê đã ép
                    int starEmpty = 0; //lỗ sao pha lê                    

                    if (DanhHieu != null && DaPhaLe != null) {

                        for (Item.ItemOption io : DanhHieu.itemOptions) {
                            if (io.optionTemplate.id == 102) {
                                star = io.param;
                            } else if (io.optionTemplate.id == 107) {
                                starEmpty = io.param;
                            }
                        }
                        if (star < starEmpty) {
                            player.combineNew.gemCombine = getGemEpSao(star);
                            String npcSay = DanhHieu.template.name + "\n|2|";
                            for (Item.ItemOption io : DanhHieu.itemOptions) {
                                if (io.optionTemplate.id != 102) {
                                    npcSay += io.getOptionString() + "\n";
                                }
                            }
                            if (DaPhaLe.template.id == 1399) {
                                for (Item.ItemOption io : DaPhaLe.itemOptions) {
                                    npcSay += "|7|" + io.getOptionString() + "\n";
                                }
                            } else {
                                npcSay += "|7|" + ItemService.gI().getItemOptionTemplate(getOptionDaPhaLe(DaPhaLe)).name.replaceAll("#", getParamDaPhaLe(DaPhaLe) + "") + "\n";
                            }
                            npcSay += "|1|Cần " + Util.numberToMoney(player.combineNew.gemCombine) + " ngọc";
                            baHatMit.createOtherMenu(player, ConstNpc.MENU_START_COMBINE, npcSay,
                                    "Nâng cấp\ncần " + player.combineNew.gemCombine + " ngọc");

                        } else {
                            this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU,
                                    "Cần 1 trang bị có lỗ sao pha lê và 1 loại đá pha lê để ép vào", "Đóng");
                        }
                    } else {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU,
                                "Cần 1 trang bị có lỗ sao pha lê và 1 loại đá pha lê để ép vào", "Đóng");
                    }
                } else {
                    this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU,
                            "Cần 1 trang bị có lỗ sao pha lê và 1 loại đá pha lê để ép vào", "Đóng");
                }
                break;
            case TAY_PS_HOA_TRANG_BI:
                if (InventoryServiceNew.gI().getCountEmptyBag(player) > 0) {
                    if (player.combineNew.itemsCombine.size() == 2) {
                        Item daHacHoa = null;
                        Item itemHacHoa = null;
                        for (Item item_ : player.combineNew.itemsCombine) {
                            if (item_.template.id == 2047) {
                                daHacHoa = item_;
                            } else if (item_.isTrangBiHacHoa()) {
                                itemHacHoa = item_;
                            }
                        }
                        if (daHacHoa == null) {
                            this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Bạn còn bùa giải pháp sư", "Đóng");
                            return;
                        }
                        if (itemHacHoa == null) {
                            this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Bạn còn thiếu trang bị", "Đóng");
                            return;
                        }

                        String npcSay = "|2|Hiện tại " + itemHacHoa.template.name + "\n|0|";
                        for (Item.ItemOption io : itemHacHoa.itemOptions) {
                            if (io.optionTemplate.id != 72) {
                                npcSay += io.getOptionString() + "\n";
                            }
                        }
                        npcSay += "|2|Sau khi nâng cấp sẽ xoá hết các chỉ số pháp sư ngẫu nhiên \n|7|"
                                + "\n|7|Tỉ lệ thành công: " + player.combineNew.ratioCombine + "%\n"
                                + "Cần " + Util.numberToMoney(COST) + " vàng";

                        this.baHatMit.createOtherMenu(player, ConstNpc.MENU_START_COMBINE,
                                npcSay, "Nâng cấp\n" + Util.numberToMoney(COST) + " vàng", "Từ chối");
                    } else {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Cần có trang bị có thể pháp sư và bùa giải pháp sư", "Đóng");
                    }
                } else {
                    this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Hành trang cần ít nhất 1 chỗ trống", "Đóng");
                }

                break;
            case PS_HOA_TRANG_BI:
                if (InventoryServiceNew.gI().getCountEmptyBag(player) > 0) {
                    if (player.combineNew.itemsCombine.size() == 2) {
                        Item daHacHoa = null;
                        Item itemHacHoa = null;
                        for (Item item_ : player.combineNew.itemsCombine) {
                            if (item_.template.id == 2046) {
                                daHacHoa = item_;
                            } else if (item_.isTrangBiHacHoa()) {
                                itemHacHoa = item_;
                            }
                        }
                        if (daHacHoa == null) {
                            this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Bạn còn thiếu đá pháp sư", "Đóng");
                            return;
                        }
                        if (itemHacHoa == null) {
                            this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Bạn còn thiếu trang bị", "Đóng");
                            return;
                        }
                        if (itemHacHoa != null) {
                            for (ItemOption itopt : itemHacHoa.itemOptions) {
                                if (itopt.optionTemplate.id == 223) {
                                    if (itopt.param >= 8) {
                                        Service.getInstance().sendThongBao(player, "Trang bị đã đạt tới giới hạn pháp sư");
                                        return;
                                    }
                                }
                            }
                        }
                        String npcSay = "|2|Hiện tại " + itemHacHoa.template.name + "\n|0|";
                        for (Item.ItemOption io : itemHacHoa.itemOptions) {
                            if (io.optionTemplate.id != 72) {
                                npcSay += io.getOptionString() + "\n";
                            }
                        }
                        npcSay += "|2|Sau khi nâng cấp sẽ cộng 1 chỉ số pháp sư ngẫu nhiên \n|7|"
                                + "\n|7|Tỉ lệ thành công: " + player.combineNew.ratioCombine + "%\n"
                                + "Cần " + Util.numberToMoney(COST) + " vàng " + "\nCần" + Util.numberToMoney(RUBY) + "Hồng ngọc";

                        this.baHatMit.createOtherMenu(player, ConstNpc.MENU_START_COMBINE,
                                npcSay, "Nâng cấp", "Từ chối");
                    } else {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Cần có trang bị có thể pháp sư và đá pháp sư", "Đóng");
                    }
                } else {
                    this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Hành trang cần ít nhất 1 chỗ trống", "Đóng");
                }

                break;

            case TINH_LUYEN_TRANG_BI:
                if (InventoryServiceNew.gI().getCountEmptyBag(player) > 0) {
                    if (player.combineNew.itemsCombine.size() == 5) {
                        Item TBTinhAn = null;
                        Item ManhTinhAn = null;
                        Item LuaThan = null;
                        Item VinhDu = null;
                        Item DaTinhLuyen = null;

                        for (Item item : player.combineNew.itemsCombine) {
                            if (item.isNotNullItem()) {
                                if (item.template.id >= 1048 && item.template.id <= 1062) {
                                    TBTinhAn = item;
                                } else if (item.template.id == 1232) {
                                    ManhTinhAn = item;
                                } else if (item.template.id == 1250) {
                                    LuaThan = item;
                                } else if (item.template.id == 1249) {
                                    VinhDu = item;
                                } else if (item.template.id == 1265) {
                                    DaTinhLuyen = item;
                                }
                            }
                        }

                        int level_34 = 0;
                        Item.ItemOption optionLevel_34 = null;
                        for (Item.ItemOption io : TBTinhAn.itemOptions) {
                            if (io.optionTemplate.id == 34) {
                                level_34 = io.param;
                                optionLevel_34 = io;
                                break;
                            }
                        }

                        if (TBTinhAn == null) {
                            this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Bạn còn thiếu Trang Bị Thiên Sứ Tinh Ấn", "Đóng");
                            return;
                        }
                        if (ManhTinhAn == null) {
                            this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Bạn còn thiếu Mảnh Tinh Ấn", "Đóng");
                            return;
                        }
                        if (LuaThan == null) {
                            this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Bạn còn thiếu Lửa Thần", "Đóng");
                            return;
                        }
                        if (VinhDu == null) {
                            this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Bạn còn thiếu Vinh Dự Samurai", "Đóng");
                            return;
                        }
                        if (DaTinhLuyen == null) {
                            this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Bạn còn thiếu Đá Tinh Luyện", "Đóng");
                            return;
                        }

                        if (TBTinhAn != null) {
                            for (ItemOption itopt : TBTinhAn.itemOptions) {
                                if (itopt.optionTemplate.id == 203) {
                                    if (itopt.param >= 10) {
                                        Service.getInstance().sendThongBao(player, "Trang Bị Đã Tinh Ấn tối đa");
                                        return;
                                    }
                                }
                            }
                        }

                        String npcSay = "|2|Hiện tại " + TBTinhAn.template.name + "\n|0|";
                        for (Item.ItemOption io : TBTinhAn.itemOptions) {
                            npcSay += io.getOptionString() + "\n";

                        }
                        npcSay += "|2|Sau khi nâng cấp sẽ tăng sức mạnh vượt bậc! Nhưng cũng hên xui :)) \n|7|"
                                + "Cần " + Util.numberToMoney(COST_TINH_LUYEN) + " vàng " + "\nCần" + Util.numberToMoney(RUBY) + "Hồng ngọc, Ngọc Xanh";

                        this.baHatMit.createOtherMenu(player, ConstNpc.MENU_START_COMBINE,
                                npcSay, "Tinh Luyện", "Từ chối");
                    } else {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Bạn chưa đủ điều kiện để tinh luyện", "Đóng");
                    }
                } else {
                    this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Hành trang cần ít nhất 1 chỗ trống", "Đóng");
                }

                break;

            case LUYEN_BI_TICH:
                if (InventoryServiceNew.gI().getCountEmptyBag(player) > 0) {
                    if (player.combineNew.itemsCombine.size() == 2) {
                        Item BiTich = null;
                        Item SachLuyen = null;

                        for (Item item : player.combineNew.itemsCombine) {
                            if (item.isNotNullItem()) {
                                if (item.template.id == 1393) {
                                    BiTich = item;
                                } else if (item.template.id == 1392) {
                                    SachLuyen = item;
                                }
                            }
                        }

                        int level_224 = 0;
                        Item.ItemOption optionLevel_224 = null;
                        for (Item.ItemOption io : BiTich.itemOptions) {
                            if (io.optionTemplate.id == 224) {
                                level_224 = io.param;
                                optionLevel_224 = io;
                                break;
                            }
                        }

                        if (BiTich == null) {
                            this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Bạn còn thiếu Bí Tịch", "Đóng");
                            return;
                        }
                        if (SachLuyen == null) {
                            this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Bạn còn thiếu Sách Luyện Bí Tịch", "Đóng");
                            return;
                        }

                        if (BiTich != null) {
                            for (ItemOption itopt : BiTich.itemOptions) {
                                if (itopt.optionTemplate.id == 224) {
                                    if (itopt.param <= 0) {
                                        Service.getInstance().sendThongBao(player, "Bí Tịch không thể Luyện do hết số lần luyện");
                                        return;
                                    }
                                }
                            }
                        }

                        String npcSay = "|2|Hiện tại " + BiTich.template.name + "\n|0|";
                        for (Item.ItemOption io : BiTich.itemOptions) {
                            npcSay += io.getOptionString() + "\n";

                        }
                        npcSay += "|2|Sau khi nâng cấp sẽ tăng sức mạnh vượt bậc \n|7|"
                                + "Cần " + Util.numberToMoney(100_000_000) + " vàng " + "\nCần" + Util.numberToMoney(1000) + "Hồng ngọc, Ngọc Xanh";

                        this.baHatMit.createOtherMenu(player, ConstNpc.MENU_START_COMBINE,
                                npcSay, "Luyện \n Bí Tịch", "Từ chối");
                    } else {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Bạn chưa đủ điều kiện để luyện bí tịch", "Đóng");
                    }
                } else {
                    this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Hành trang cần ít nhất 1 chỗ trống", "Đóng");
                }

                break;

            case EP_CHUNG_NHAN_XUAT_SU:
                if (player.combineNew.itemsCombine.size() == 2) {
                    Item Porata = null;
                    Item CNXuatSu = null;
                    for (Item item : player.combineNew.itemsCombine) {
                        if (item.template.id == 921 || item.template.id == 1155 || item.template.id == 1156) {
                            Porata = item;
                        } else if (item.template.id == 720) {
                            CNXuatSu = item;
                        }
                    }

                    int level_41 = 0;
                    Item.ItemOption optionLevel_41 = null;
                    for (Item.ItemOption io : Porata.itemOptions) {
                        if (io.optionTemplate.id == 41) {
                            level_41 = io.param;
                            optionLevel_41 = io;
                            break;
                        }
                    }
                    if (Porata == null) {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Bạn còn thiếu Porata Cấp 2", "Đóng");
                        return;
                    }
                    if (CNXuatSu == null) {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Bạn còn thiếu Chứng Nhận Xuất Sư", "Đóng");
                        return;
                    }
                    if (Porata != null) {
                        if (level_41 < MAX_EP_CHUNG_NHAN) {
                            player.combineNew.goldCombine = 100_000_000;
                            player.combineNew.gemCombine = 1000;

                            String npcSay = Porata.template.name + "\n|2|";
                            for (Item.ItemOption io : Porata.itemOptions) {
                                if (io.optionTemplate.id != 102) {
                                    npcSay += io.getOptionString() + "\n";
                                }
                            }
                            npcSay += "|7|Tỉ lệ thành công: " + player.combineNew.ratioCombine + "%" + "\n";
                            if (player.combineNew.goldCombine <= player.inventory.gold) {
                                npcSay += "|1|Cần " + Util.numberToMoney(player.combineNew.goldCombine) + " vàng";
                                baHatMit.createOtherMenu(player, ConstNpc.MENU_START_COMBINE, npcSay,
                                        "Nâng cấp\ncần " + player.combineNew.gemCombine + " ngọc");
                            } else {
                                npcSay += "Còn thiếu " + Util.numberToMoney(player.combineNew.goldCombine - player.inventory.gold) + " vàng";
                                baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, npcSay, "Đóng");
                            }

                        } else {
                            this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Bông tai đã ép chứng nhận tối đa", "Đóng");
                        }
                    }
                } else {
                    this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Cần Porata Cấp 2 và Chứng Nhận Xuất Sư", "Đóng");
                }
                break;

            case PHA_LE_HOA_TRANG_BI:
                if (player.combineNew.itemsCombine.size() == 1) {
                    Item item = player.combineNew.itemsCombine.get(0);
                    if (isTrangBiPhaLeHoa(item)) {
                        int star = 0;
                        for (Item.ItemOption io : item.itemOptions) {
                            if (io.optionTemplate.id == 107) {
                                star = io.param;
                                break;
                            }
                        }
                        if (star < MAX_STAR_ITEM) {
                            player.combineNew.goldCombine = getGoldPhaLeHoa(star);
                            player.combineNew.gemCombine = getGemPhaLeHoa(star);
                            player.combineNew.ratioCombine = getRatioPhaLeHoa(star);

                            String npcSay = item.template.name + "\n|2|";
                            for (Item.ItemOption io : item.itemOptions) {
                                if (io.optionTemplate.id != 102) {
                                    npcSay += io.getOptionString() + "\n";
                                }
                            }
                            npcSay += "|7|Tỉ lệ thành công: " + player.combineNew.ratioCombine + "%" + "\n";
                            if (player.combineNew.goldCombine <= player.inventory.gold) {
                                npcSay += "|1|Cần " + Util.numberToMoney(player.combineNew.goldCombine) + " vàng";
                                baHatMit.createOtherMenu(player, ConstNpc.MENU_START_COMBINE, npcSay,
                                        "Nâng cấp\n" + player.combineNew.gemCombine + " ngọc\n" + "1 lần", "Nâng cấp\n" + (player.combineNew.gemCombine * 10) + " ngọc\n" + "10 Lần", "Nâng cấp\n" + (player.combineNew.gemCombine * 100) + " ngọc\n" + "100 lần", "Nâng cấp\n" + (player.combineNew.gemCombine * 1000) + " ngọc\n" + "1000 lần");
                            } else {
                                npcSay += "Còn thiếu " + Util.numberToMoney(player.combineNew.goldCombine - player.inventory.gold) + " vàng";
                                baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, npcSay, "Đóng");
                            }

                        } else {
                            this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Vật phẩm đã đạt tối đa sao pha lê", "Đóng");
                        }
                    } else {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Vật phẩm này không thể đục lỗ", "Đóng");
                    }
                } else {
                    this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Hãy hãy chọn 1 vật phẩm để pha lê hóa", "Đóng");
                }
                break;

            case NHAP_NGOC_RONG:
                if (InventoryServiceNew.gI().getCountEmptyBag(player) > 0) {
                    if (player.combineNew.itemsCombine.size() == 1) {
                        Item item = player.combineNew.itemsCombine.get(0);
                        if (item != null && item.isNotNullItem() && (item.template.id > 14 && item.template.id <= 20) && item.quantity >= 7) {
                            String npcSay = "|2|Con có muốn biến 10 " + item.template.name + " thành\n"
                                    + "1 viên " + ItemService.gI().getTemplate((short) (item.template.id - 1)).name + "\n"
                                    + "|7|Cần 7 " + item.template.name;
                            this.baHatMit.createOtherMenu(player, ConstNpc.MENU_START_COMBINE, npcSay, "Làm phép", "Từ chối");
                        }
                    } else {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Cần 7 viên ngọc rồng cùng sao trở lên", "Đóng");
                    }
                } else {
                    this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Hành trang cần ít nhất 1 chỗ trống", "Đóng");
                }
                break;
            case AN_TRANG_BI:
                if (InventoryServiceNew.gI().getCountEmptyBag(player) > 0) {
                    if (player.combineNew.itemsCombine.size() == 2) {
                        Item item = player.combineNew.itemsCombine.get(0);
                        Item dangusac = player.combineNew.itemsCombine.get(1);
                        if (isTrangBiAn(item)) {
                            if (item != null && item.isNotNullItem() && dangusac != null && dangusac.isNotNullItem() && (dangusac.template.id == 1232 || dangusac.template.id == 1233 || dangusac.template.id == 1234) && dangusac.quantity >= 99) {
                                String npcSay = item.template.name + "\n|2|";
                                for (Item.ItemOption io : item.itemOptions) {
                                    npcSay += io.getOptionString() + "\n";
                                }
                                npcSay += "|1|Con có muốn biến trang bị " + item.template.name + " thành\n"
                                        + "trang bị Ấn không?\b|4|Tỉ lệ thành công: 50%\n"
                                        + "|7|Cần 99 " + dangusac.template.name + "\nCần " + Util.numberToMoney(COST) + " vàng" + "\nCần " + Util.numberToMoney(RUBY) + "hồng ngọc";
                                this.baHatMit.createOtherMenu(player, ConstNpc.MENU_START_COMBINE, npcSay, "Làm phép", "Từ chối");
                            } else {
                                this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Bạn chưa bỏ đủ vật phẩm !!!", "Đóng");
                            }
                        } else {
                            this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Vật phẩm này không thể hóa ấn", "Đóng");
                        }
                    } else {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Cần bỏ đủ vật phẩm yêu cầu", "Đóng");
                    }
                } else {
                    this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Hành trang cần ít nhất 1 chỗ trống", "Đóng");
                }
                break;
            case NANG_CAP_VAT_PHAM:
                if (player.combineNew.itemsCombine.size() >= 2 && player.combineNew.itemsCombine.size() < 4) {
                    if (player.combineNew.itemsCombine.stream().filter(item -> item.isNotNullItem() && item.template.type < 5).count() < 1) {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Thiếu đồ nâng cấp", "Đóng");
                        break;
                    }
                    if (player.combineNew.itemsCombine.stream().filter(item -> item.isNotNullItem() && item.template.type == 14).count() < 1) {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Thiếu đá nâng cấp", "Đóng");
                        break;
                    }
                    if (player.combineNew.itemsCombine.size() == 3 && player.combineNew.itemsCombine.stream().filter(item -> item.isNotNullItem() && item.template.id == 987).count() < 1) {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Thiếu đồ nâng cấp", "Đóng");
                        break;
                    }
                    Item itemDo = null;
                    Item itemDNC = null;
                    Item itemDBV = null;
                    for (int j = 0; j < player.combineNew.itemsCombine.size(); j++) {
                        if (player.combineNew.itemsCombine.get(j).isNotNullItem()) {
                            if (player.combineNew.itemsCombine.size() == 3 && player.combineNew.itemsCombine.get(j).template.id == 987) {
                                itemDBV = player.combineNew.itemsCombine.get(j);
                                continue;
                            }
                            if (player.combineNew.itemsCombine.get(j).template.type < 5) {
                                itemDo = player.combineNew.itemsCombine.get(j);
                            } else {
                                itemDNC = player.combineNew.itemsCombine.get(j);
                            }
                        }
                    }
                    if (isCoupleItemNangCapCheck(itemDo, itemDNC)) {
                        int level = 0;
                        for (Item.ItemOption io : itemDo.itemOptions) {
                            if (io.optionTemplate.id == 72) {
                                level = io.param;
                                break;
                            }
                        }
                        if (level < MAX_LEVEL_ITEM) {
                            player.combineNew.goldCombine = getGoldNangCapDo(level);
                            player.combineNew.ratioCombine = (float) getTileNangCapDo(level);
                            player.combineNew.countDaNangCap = getCountDaNangCapDo(level);
                            player.combineNew.countDaBaoVe = (short) getCountDaBaoVe(level);
                            String npcSay = "|2|Hiện tại " + itemDo.template.name + " (+" + level + ")\n|0|";
                            for (Item.ItemOption io : itemDo.itemOptions) {
                                if (io.optionTemplate.id != 72) {
                                    npcSay += io.getOptionString() + "\n";
                                }
                            }
                            String option = null;
                            int param = 0;
                            for (Item.ItemOption io : itemDo.itemOptions) {
                                if (io.optionTemplate.id == 47
                                        || io.optionTemplate.id == 6
                                        || io.optionTemplate.id == 0
                                        || io.optionTemplate.id == 7
                                        || io.optionTemplate.id == 14
                                        || io.optionTemplate.id == 22
                                        || io.optionTemplate.id == 23
                                        || io.optionTemplate.id == 43
                                        || io.optionTemplate.id == 44) {
                                    option = io.optionTemplate.name;
                                    param = io.param + (io.param * 10 / 100);
                                    break;
                                }
                            }
                            npcSay += "|2|Sau khi nâng cấp (+" + (level + 1) + ")\n|7|"
                                    + option.replaceAll("#", String.valueOf(param))
                                    + "\n|7|Tỉ lệ thành công: " + player.combineNew.ratioCombine + "%\n"
                                    + (player.combineNew.countDaNangCap > itemDNC.quantity ? "|7|" : "|1|")
                                    + "Cần " + player.combineNew.countDaNangCap + " " + itemDNC.template.name
                                    + "\n" + (player.combineNew.goldCombine > player.inventory.gold ? "|7|" : "|1|")
                                    + "Cần " + Util.numberToMoney(player.combineNew.goldCombine) + " vàng";

                            String daNPC = player.combineNew.itemsCombine.size() == 3 && itemDBV != null ? String.format("\nCần tốn %s đá bảo vệ", player.combineNew.countDaBaoVe) : "";
                            if ((level == 2 || level == 4 || level == 6) && !(player.combineNew.itemsCombine.size() == 3 && itemDBV != null)) {
                                npcSay += "\nNếu thất bại sẽ rớt xuống (+" + (level - 1) + ")";
                            }
                            if (player.combineNew.countDaNangCap > itemDNC.quantity) {
                                this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU,
                                        npcSay, "Còn thiếu\n" + (player.combineNew.countDaNangCap - itemDNC.quantity) + " " + itemDNC.template.name);
                            } else if (player.combineNew.goldCombine > player.inventory.gold) {
                                this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU,
                                        npcSay, "Còn thiếu\n" + Util.numberToMoney((player.combineNew.goldCombine - player.inventory.gold)) + " vàng");
                            } else if (player.combineNew.itemsCombine.size() == 3 && Objects.nonNull(itemDBV) && itemDBV.quantity < player.combineNew.countDaBaoVe) {
                                this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU,
                                        npcSay, "Còn thiếu\n" + (player.combineNew.countDaBaoVe - itemDBV.quantity) + " đá bảo vệ");
                            } else {
                                this.baHatMit.createOtherMenu(player, ConstNpc.MENU_START_COMBINE,
                                        npcSay, "Nâng cấp\n" + Util.numberToMoney(player.combineNew.goldCombine) + " vàng" + daNPC, "Từ chối");
                            }
                        } else {
                            this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Trang bị của ngươi đã đạt cấp tối đa", "Đóng");
                        }
                    } else {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Hãy chọn 1 trang bị và 1 loại đá nâng cấp", "Đóng");
                    }
                } else {
                    if (player.combineNew.itemsCombine.size() > 3) {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Cất đi con ta không thèm", "Đóng");
                        break;
                    }
                    this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Hãy chọn 1 trang bị và 1 loại đá nâng cấp", "Đóng");
                }
                break;
            case PHAN_RA_DO_THAN_LINH:
                if (player.combineNew.itemsCombine.size() == 0) {
                    this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Con hãy đưa ta đồ thần linh để phân rã", "Đóng");
                    return;
                }
                if (player.combineNew.itemsCombine.size() == 1) {
                    List<Integer> itemdov2 = new ArrayList<>(Arrays.asList(562, 564, 566));
                    int couponAdd = 0;
                    Item item = player.combineNew.itemsCombine.get(0);
                    if (item.isNotNullItem()) {
                        if (item.template.id >= 555 && item.template.id <= 567) {
                            couponAdd = itemdov2.stream().anyMatch(t -> t == item.template.id) ? 2 : item.template.id == 561 ? 3 : 1;
                        }
                    }
                    if (couponAdd == 0) {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Ta chỉ có thể phân rã đồ thần linh thôi", "Đóng");
                        return;
                    }
                    String npcSay = "|2|Sau khi phân rã vật phẩm\n|7|"
                            + "Bạn sẽ nhận được : " + couponAdd + " Đá Ngũ Sắc\n"
                            + (500000000 > player.inventory.gold ? "|7|" : "|1|")
                            + "Cần " + Util.numberToMoney(50000000) + " vàng";

                    if (player.inventory.gold < 50000000) {
                        this.baHatMit.npcChat(player, "Con không đủ 50TR vàng");
                        return;
                    }
                    this.baHatMit.createOtherMenu(player, ConstNpc.MENU_PHAN_RA_DO_THAN_LINH,
                            npcSay, "Phân Rã\n" + Util.numberToMoney(50000000) + " vàng", "Từ chối");
                } else {
                    this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Ta chỉ có thể phân rã 1 lần 1 món đồ thần linh", "Đóng");
                }
                break;
            case DOI_DIEM:
                if (player.combineNew.itemsCombine.size() == 0) {
                    this.npsthiensu64.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Con hãy đưa cho ta thức ăn", "Đóng");
                    return;
                }
                if (player.combineNew.itemsCombine.size() == 1) {
                    List<Integer> itemdov2 = new ArrayList<>(Arrays.asList(663, 664, 665, 666, 667));
                    int couponAdd = 0;
                    Item item = player.combineNew.itemsCombine.get(0);
                    if (item.isNotNullItem()) {
                        if (item.template.id >= 663 && item.template.id <= 667) {
                            couponAdd = itemdov2.stream().anyMatch(t -> t == item.template.id) ? 1 : item.template.id <= 667 ? 1 : 1;
                        }
                    }
                    if (couponAdd == 0) {
                        this.npsthiensu64.createOtherMenu(player, ConstNpc.IGNORE_MENU, "THỨC ĂN!!!!!!!!", "Đóng");
                        return;
                    }
                    String npcSay = "|2|Sau khi phân rã vật phẩm\n|7|"
                            + "Bạn sẽ nhận được : " + couponAdd + " điểm\n"
                            + (500000000 > player.inventory.gold ? "|7|" : "|1|")
                            + "Cần " + Util.numberToMoney(500000000) + " vàng";

                    if (player.inventory.gold < 500000000) {
                        this.npsthiensu64.npcChat(player, "Hết tiền rồi\nẢo ít thôi con");
                        return;
                    }
                    this.npsthiensu64.createOtherMenu(player, ConstNpc.MENU_PHAN_RA_DO_THAN_LINH,
                            npcSay, "Thức Ăn", "Từ chối");
                } else {
                    this.npsthiensu64.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Cái Đầu Buồi", "Đóng");
                }
                break;
            case NANG_CAP_DO_TS:
                if (player.combineNew.itemsCombine.size() == 0) {
                    this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Hãy đưa ta 2 món Hủy Diệt bất kì và 1 món Thần Linh cùng loại", "Đóng");
                    return;
                }
                if (player.combineNew.itemsCombine.size() == 4) {
                    if (player.combineNew.itemsCombine.stream().filter(item -> item.isNotNullItem() && item.isDTL()).count() < 1) {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Thiếu đồ thần linh", "Đóng");
                        return;
                    }
                    if (player.combineNew.itemsCombine.stream().filter(item -> item.isNotNullItem() && item.isDHD()).count() < 2) {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Thiếu đồ hủy diệt", "Đóng");
                        return;
                    }
                    if (player.combineNew.itemsCombine.stream().filter(item -> item.isNotNullItem() && item.isManhTS() && item.quantity >= 999).count() < 1) {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Thiếu mảnh thiên sứ", "Đóng");
                        return;
                    }

                    String npcSay = "|2|Con có muốn đổi các món nguyên liệu ?\n|7|"
                            + "Và nhận được " + player.combineNew.itemsCombine.stream().filter(Item::isManhTS).findFirst().get().typeNameManh() + " thiên sứ tương ứng\n"
                            + "|1|Cần " + Util.numberToMoney(COST) + " vàng";

                    if (player.inventory.gold < COST) {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Con không đủ vàng", "Đóng");
                        return;
                    }
                    this.baHatMit.createOtherMenu(player, ConstNpc.MENU_NANG_CAP_DO_TS,
                            npcSay, "Nâng cấp\n" + Util.numberToMoney(COST) + " vàng", "Từ chối");
                } else {
                    if (player.combineNew.itemsCombine.size() > 3) {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Còn thiếu nguyên liệu để nâng cấp hãy quay lại sau", "Đóng");
                        return;
                    }
                    this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Còn thiếu nguyên liệu để nâng cấp hãy quay lại sau", "Đóng");
                }
                break;
            case NANG_CAP_SKH_VIP:
                if (player.combineNew.itemsCombine.size() == 0) {
                    this.npsthiensu64.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Hãy đưa ta 1 món thiên sứ và 2 món SKH ngẫu nhiên", "Đóng");
                    return;
                }
                if (player.combineNew.itemsCombine.size() == 3) {
                    if (player.combineNew.itemsCombine.stream().filter(item -> item.isNotNullItem() && item.isDTS()).count() < 1) {
                        this.npsthiensu64.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Thiếu đồ thiên sứ", "Đóng");
                        return;
                    }
                    if (player.combineNew.itemsCombine.stream().filter(item -> item.isNotNullItem() && item.isSKH()).count() < 2) {
                        this.npsthiensu64.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Thiếu đồ kích hoạt ", "Đóng");
                        return;
                    }

                    String npcSay = "|2|Con có muốn đổi các món nguyên liệu ?\n|7|"
                            + "Và nhận được " + player.combineNew.itemsCombine.stream().filter(Item::isDTS).findFirst().get().typeName() + " kích hoạt VIP tương ứng\n"
                            + "|1|Cần " + Util.numberToMoney(COST) + " vàng";

                    if (player.inventory.gold < COST) {
                        this.npsthiensu64.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Hết tiền rồi\nẢo ít thôi con", "Đóng");
                        return;
                    }
                    this.npsthiensu64.createOtherMenu(player, ConstNpc.MENU_NANG_DOI_SKH_VIP,
                            npcSay, "Nâng cấp\n" + Util.numberToMoney(COST) + " vàng", "Từ chối");
                } else {
                    if (player.combineNew.itemsCombine.size() > 3) {
                        this.npsthiensu64.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Nguyên liệu không phù hợp", "Đóng");
                        return;
                    }
                    this.npsthiensu64.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Còn thiếu nguyên liệu để nâng cấp hãy quay lại sau", "Đóng");
                }
                break;
            case NANG_CAP_CHAN_MENH:
                if (player.combineNew.itemsCombine.size() == 0) {
                    this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU,
                            "Hãy đưa ta chân mệnh và 5 viên ngọc rồng 1s ta sẽ phù phép cho !",
                            "Đóng");
                    return;
                }

                if (player.combineNew.itemsCombine.size() == 2) {
                    if (player.combineNew.itemsCombine.stream().filter(
                            item -> item.isNotNullItem() && (item.template.id >= 1328 && item.template.id <= 1335))
                            .count() < 1) {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Thiếu chân mệnh", "Đóng");
                        return;
                    }
                    if (player.combineNew.itemsCombine.stream()
                            .filter(item -> item.isNotNullItem() && item.template.id == 674)
                            .count() < 1) {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Thiếu đá ngũ sắc", "Đóng");
                        return;
                    }

                    String npcSay = "|2|Con có muốn đổi các món nguyên liệu ?\n|7|"
                            + "|7|Chân mệnh "
                            + "10 viên ngọc rồng 1 sao + 5k HN";

                    if (player.inventory.ruby < 1000) {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Hết tiền rồi\nẢo ít thôi con",
                                "Đóng");
                        return;
                    }
                    this.baHatMit.createOtherMenu(player, ConstNpc.MENU_START_COMBINE,
                            npcSay, "Nâng cấp\n" + "5k" + " hồng ngọc", "Từ chối");
                } else {
                    if (player.combineNew.itemsCombine.size() > 2) {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Nguyên liệu không phù hợp",
                                "Đóng");
                        return;
                    }
                    this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU,
                            "Còn thiếu nguyên liệu để nâng cấp hãy quay lại sau", "Đóng");
                }
                break;
            case NANG_CAP_BONG_TAI:
                if (player.combineNew.itemsCombine.size() == 2) {
                    Item bongTai = null;
                    Item manhVo = null;
                    for (Item item : player.combineNew.itemsCombine) {
                        if (item.template.id == 454) {
                            bongTai = item;
                        } else if (item.template.id == 933) {
                            manhVo = item;
                        }
                    }
                    if (bongTai != null && manhVo != null && manhVo.quantity >= 999) {

                        player.combineNew.goldCombine = GOLD_BONG_TAI;
                        player.combineNew.gemCombine = GEM_BONG_TAI;
                        player.combineNew.ratioCombine = RATIO_BONG_TAI;

                        String npcSay = "Bông tai Porata cấp 2" + "\n|2|";
                        for (Item.ItemOption io : bongTai.itemOptions) {
                            npcSay += io.getOptionString() + "\n";
                        }
                        npcSay += "|7|Tỉ lệ thành công: " + player.combineNew.ratioCombine + "%" + "\n";
                        if (player.combineNew.goldCombine <= player.inventory.gold) {
                            npcSay += "|1|Cần " + Util.numberToMoney(player.combineNew.goldCombine) + " vàng";
                            baHatMit.createOtherMenu(player, ConstNpc.MENU_START_COMBINE, npcSay,
                                    "Nâng cấp\ncần " + player.combineNew.gemCombine + " ngọc");
                        } else {
                            npcSay += "Còn thiếu " + Util.numberToMoney(player.combineNew.goldCombine - player.inventory.gold) + " vàng";
                            baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, npcSay, "Đóng");
                        }
                    } else {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU,
                                "Cần 1 Bông tai Porata cấp 1 và X99 Mảnh vỡ bông tai", "Đóng");
                    }
                } else {
                    this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU,
                            "Cần 1 Bông tai Porata cấp 1 và X99 Mảnh vỡ bông tai", "Đóng");
                }
                break;
            case MO_CHI_SO_BONG_TAI:
                if (player.combineNew.itemsCombine.size() == 3) {
                    Item bongTai = null;
                    Item manhHon = null;
                    Item daXanhLam = null;
                    for (Item item : player.combineNew.itemsCombine) {
                        if (item.template.id == 921) {
                            bongTai = item;
                        } else if (item.template.id == 934) {
                            manhHon = item;
                        } else if (item.template.id == 935) {
                            daXanhLam = item;
                        }
                    }
                    if (bongTai != null && manhHon != null && daXanhLam != null && manhHon.quantity >= 99) {

                        player.combineNew.goldCombine = GOLD_BONG_TAI;
                        player.combineNew.gemCombine = GEM_BONG_TAI;
                        player.combineNew.ratioCombine = RATIO_NANG_CAP;

                        String npcSay = "Bông tai Porata cấp 2" + "\n|2|";
                        for (Item.ItemOption io : bongTai.itemOptions) {
                            npcSay += io.getOptionString() + "\n";
                        }
                        npcSay += "|7|Tỉ lệ thành công: " + player.combineNew.ratioCombine + "%" + "\n";
                        if (player.combineNew.goldCombine <= player.inventory.gold) {
                            npcSay += "|1|Cần " + Util.numberToMoney(player.combineNew.goldCombine) + " vàng";
                            baHatMit.createOtherMenu(player, ConstNpc.MENU_START_COMBINE, npcSay,
                                    "Nâng cấp\ncần " + player.combineNew.gemCombine + " ngọc");
                        } else {
                            npcSay += "Còn thiếu " + Util.numberToMoney(player.combineNew.goldCombine - player.inventory.gold) + " vàng";
                            baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, npcSay, "Đóng");
                        }
                    } else {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU,
                                "Cần 1 Bông tai Porata cấp 2, X99 Mảnh hồn bông tai và 1 Đá xanh lam", "Đóng");
                    }
                } else {
                    this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU,
                            "Cần 1 Bông tai Porata cấp 2, X99 Mảnh hồn bông tai và 1 Đá xanh lam", "Đóng");
                }
                break;
            case NANG_CAP_BONG_TAI_CAP3:
                if (player.combineNew.itemsCombine.size() == 2) {
                    Item bongTai = null;
                    Item mvbt = null;
                    for (Item item : player.combineNew.itemsCombine) {
                        if (item.template.id == 921) {
                            bongTai = item;
                        } else if (item.template.id == 933) {
                            mvbt = item;
                        }
                    }
                    if (bongTai != null && mvbt != null && mvbt.quantity >= 999) {

                        player.combineNew.goldCombine = GOLD_BONG_TAI;
                        player.combineNew.gemCombine = GEM_BONG_TAI;
                        player.combineNew.ratioCombine = RATIO_BONG_TAI;
                        player.combineNew.rubyCombine = RUBY_BONG_TAI;
                        String npcSay = "Bông tai Porata cấp 3" + "\n|2|";
                        for (Item.ItemOption io : bongTai.itemOptions) {
                            npcSay += io.getOptionString() + "\n";
                        }
                        npcSay += "|7|Tỉ lệ thành công: " + player.combineNew.ratioCombine + "%" + "\n";
                        if (player.inventory.ruby <= player.combineNew.rubyCombine) {
                            npcSay += "Còn thiếu " + Util.numberToMoney(player.combineNew.rubyCombine - player.inventory.ruby) + " Hồng ngọc";
                            baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, npcSay, "Đóng");
                            return;
                        }
                        if (player.combineNew.goldCombine <= player.inventory.gold) {
                            npcSay += "|1|Cần " + Util.numberToMoney(player.combineNew.goldCombine) + " vàng và "
                                    + player.combineNew.rubyCombine + " hồng ngọc";
                            baHatMit.createOtherMenu(player, ConstNpc.MENU_START_COMBINE, npcSay,
                                    "Nâng cấp");
                        } else {
                            npcSay += "Còn thiếu " + Util.numberToMoney(player.combineNew.goldCombine - player.inventory.gold) + " vàng";
                            baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, npcSay, "Đóng");
                        }
                    } else {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU,
                                "Cần 1 Bông tai Porata cấp 2 , 10K Hồng Ngọc, 500 Triệu Vàng , X999 Mảnh vỡ bông tai "
                                + " và X999 Mảnh hồn bông tai", "Đóng");
                    }
                } else {
                    this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU,
                            "Cần 1 Bông tai Porata cấp 2 , 10K Hồng Ngọc, 500 Triệu Vàng , X999 Mảnh vỡ bông tai "
                            + " và X999 Mảnh hồn bông tai", "Đóng");
                }
                break;

            case MO_CHI_SO_BONG_TAI_CAP3:
                if (player.combineNew.itemsCombine.size() == 3) {
                    Item bongTai = null;
                    Item thachPhu = null;
                    Item daXanhLam = null;
                    for (Item item : player.combineNew.itemsCombine) {
                        if (item.template.id == 1155) {
                            bongTai = item;
                        } else if (item.template.id == 934) {
                            thachPhu = item;
                        } else if (item.template.id == 935) {
                            daXanhLam = item;

                        }
                    }
                    if (bongTai != null && thachPhu != null && daXanhLam != null && thachPhu.quantity >= 499) {
                        player.combineNew.goldCombine = GOLD_BONG_TAI;
                        player.combineNew.gemCombine = GEM_BONG_TAI;
                        player.combineNew.ratioCombine = RATIO_NANG_CAP;
                        String npcSay = "Bông tai Porata cấp 3" + "\n|2|";
                        for (Item.ItemOption io : bongTai.itemOptions) {
                            npcSay += io.getOptionString() + "\n";
                        }
                        npcSay += "|7|Tỉ lệ thành công: " + player.combineNew.ratioCombine + "%" + "\n";
                        if (player.combineNew.goldCombine <= player.inventory.gold) {
                            npcSay += "|1|Cần " + Util.numberToMoney(player.combineNew.goldCombine) + " vàng";
                            baHatMit.createOtherMenu(player, ConstNpc.MENU_START_COMBINE, npcSay,
                                    "Nâng cấp\ncần " + player.combineNew.gemCombine + " ngọc");
                        } else {
                            npcSay += "Còn thiếu " + Util.numberToMoney(player.combineNew.goldCombine - player.inventory.gold) + " vàng";
                            baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, npcSay, "Đóng");
                        }
                    } else {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU,
                                "Cần 1 Bông tai Porata cấp 3, X999 Mảnh hồn bông tai và 1 Đá xanh lam", "Đóng");
                    }
                } else {
                    this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU,
                            "Cần 1 Bông tai Porata cấp 3, X999 Mảnh hồn bông tai và 1 Đá xanh lam", "Đóng");
                }
                break;
            case NANG_CAP_BONG_TAI_CAP4:
                if (player.combineNew.itemsCombine.size() == 2) {
                    Item bongTai = null;
                    Item mvbt = null;
                    for (Item item : player.combineNew.itemsCombine) {
                        if (item.template.id == 1155) {
                            bongTai = item;
                        } else if (item.template.id == 933) {
                            mvbt = item;
                        }
                    }
                    if (bongTai != null && mvbt != null && mvbt.quantity >= 999) {

                        player.combineNew.goldCombine = GOLD_BONG_TAI;
                        player.combineNew.gemCombine = GEM_BONG_TAI;
                        player.combineNew.ratioCombine = RATIO_BONG_TAI;
                        player.combineNew.rubyCombine = RUBY_BONG_TAI;
                        String npcSay = "Bông tai Porata cấp 3" + "\n|2|";
                        for (Item.ItemOption io : bongTai.itemOptions) {
                            npcSay += io.getOptionString() + "\n";
                        }
                        npcSay += "|7|Tỉ lệ thành công: " + player.combineNew.ratioCombine + "%" + "\n";
                        if (player.inventory.ruby <= player.combineNew.rubyCombine) {
                            npcSay += "Còn thiếu " + Util.numberToMoney(player.combineNew.rubyCombine - player.inventory.ruby) + " Hồng ngọc";
                            baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, npcSay, "Đóng");
                            return;
                        }
                        if (player.combineNew.goldCombine <= player.inventory.gold) {
                            npcSay += "|1|Cần " + Util.numberToMoney(player.combineNew.goldCombine) + " vàng và "
                                    + player.combineNew.rubyCombine + " hồng ngọc";
                            baHatMit.createOtherMenu(player, ConstNpc.MENU_START_COMBINE, npcSay,
                                    "Nâng cấp");
                        } else {
                            npcSay += "Còn thiếu " + Util.numberToMoney(player.combineNew.goldCombine - player.inventory.gold) + " vàng";
                            baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, npcSay, "Đóng");
                        }
                    } else {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU,
                                "Cần 1 Bông tai Porata cấp 2 , 10K Hồng Ngọc, 500 Triệu Vàng , X999 Mảnh vỡ bông tai "
                                + " và X999 Mảnh hồn bông tai", "Đóng");
                    }
                } else {
                    this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU,
                            "Cần 1 Bông tai Porata cấp 2 , 10K Hồng Ngọc, 500 Triệu Vàng , X999 Mảnh vỡ bông tai "
                            + " và X999 Mảnh hồn bông tai", "Đóng");
                }
                break;

            case MO_CHI_SO_BONG_TAI_CAP4:
                if (player.combineNew.itemsCombine.size() == 3) {
                    Item bongTai = null;
                    Item thachPhu = null;
                    Item daXanhLam = null;
                    for (Item item : player.combineNew.itemsCombine) {
                        if (item.template.id == 1156) {
                            bongTai = item;
                        } else if (item.template.id == 934) {
                            thachPhu = item;
                        } else if (item.template.id == 935) {
                            daXanhLam = item;

                        }
                    }
                    if (bongTai != null && thachPhu != null && daXanhLam != null && thachPhu.quantity >= 499) {
                        player.combineNew.goldCombine = GOLD_BONG_TAI;
                        player.combineNew.gemCombine = GEM_BONG_TAI;
                        player.combineNew.ratioCombine = RATIO_NANG_CAP;
                        String npcSay = "Bông tai Porata cấp 3" + "\n|2|";
                        for (Item.ItemOption io : bongTai.itemOptions) {
                            npcSay += io.getOptionString() + "\n";
                        }
                        npcSay += "|7|Tỉ lệ thành công: " + player.combineNew.ratioCombine + "%" + "\n";
                        if (player.combineNew.goldCombine <= player.inventory.gold) {
                            npcSay += "|1|Cần " + Util.numberToMoney(player.combineNew.goldCombine) + " vàng";
                            baHatMit.createOtherMenu(player, ConstNpc.MENU_START_COMBINE, npcSay,
                                    "Nâng cấp\ncần " + player.combineNew.gemCombine + " ngọc");
                        } else {
                            npcSay += "Còn thiếu " + Util.numberToMoney(player.combineNew.goldCombine - player.inventory.gold) + " vàng";
                            baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, npcSay, "Đóng");
                        }
                    } else {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU,
                                "Cần 1 Bông tai Porata cấp 3, X999 Mảnh hồn bông tai và 1 Đá xanh lam", "Đóng");
                    }
                } else {
                    this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU,
                            "Cần 1 Bông tai Porata cấp 3, X999 Mảnh hồn bông tai và 1 Đá xanh lam", "Đóng");
                }
                break;
            case MO_CHI_SO_BI_TICH:
                if (player.combineNew.itemsCombine.size() == 1) {
                    Item BiTich = null;
                    for (Item item : player.combineNew.itemsCombine) {
                        if (item.template.id == 1393) {
                            BiTich = item;
                        }
                    }

                    if (BiTich != null && player.diembitich >= 300) {

                        player.combineNew.goldCombine = 500_000_000;
                        player.combineNew.gemCombine = 5000;
                        player.combineNew.ratioCombine = RATIO_MO_CHI_SO_BI_TICH;

                        String npcSay = "Mở chỉ số Bí Tịch" + "\n|2|";
                        for (Item.ItemOption io : BiTich.itemOptions) {
                            npcSay += io.getOptionString() + "\n";
                        }
                        npcSay += "|7|Tỉ lệ thành công: " + player.combineNew.ratioCombine + "%" + "\n";
                        if (player.combineNew.goldCombine <= player.inventory.gold) {
                            npcSay += "|1|Cần " + Util.numberToMoney(player.combineNew.goldCombine) + " vàng";
                            baHatMit.createOtherMenu(player, ConstNpc.MENU_START_COMBINE, npcSay,
                                    "Nâng cấp\ncần " + player.combineNew.gemCombine + " ngọc");
                        } else {
                            npcSay += "Còn thiếu " + Util.numberToMoney(player.combineNew.goldCombine - player.inventory.gold) + " vàng";
                            baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, npcSay, "Đóng");
                        }
                    } else {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU,
                                "Cần 1 Bí Tịch, 300 điểm bí tịch", "Đóng");
                    }
                } else {
                    this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU,
                            "Cần 1 Bí Tịch, 300 điểm bí tịch", "Đóng");
                }
                break;
            case CHE_TAO_TRANG_BI_TS:
                if (player.combineNew.itemsCombine.size() == 0) {
                    this.npsthiensu64.createOtherMenu(player, ConstNpc.IGNORE_MENU, "ọc ọc", "Yes");
                    return;
                }
                if (player.combineNew.itemsCombine.size() >= 2 && player.combineNew.itemsCombine.size() < 5) {
                    if (player.combineNew.itemsCombine.stream().filter(item -> item.isNotNullItem() && item.isCongThucVip()).count() < 1) {
                        this.npsthiensu64.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Thiếu Công thức Vip", "Đóng");
                        return;
                    }
                    if (player.combineNew.itemsCombine.stream().filter(item -> item.isNotNullItem() && item.isManhTS() && item.quantity >= 999).count() < 1) {
                        this.npsthiensu64.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Thiếu Mảnh đồ thiên sứ", "Đóng");
                        return;
                    }
                    if (player.combineNew.itemsCombine.size() == 3 && player.combineNew.itemsCombine.stream().filter(item -> item.isNotNullItem() && item.isDaNangCap()).count() < 1 || player.combineNew.itemsCombine.size() == 4 && player.combineNew.itemsCombine.stream().filter(item -> item.isNotNullItem() && item.isDaNangCap()).count() < 1) {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Thiếu Đá nâng cấp", "Đóng");
                        return;
                    }
                    if (player.combineNew.itemsCombine.size() == 3 && player.combineNew.itemsCombine.stream().filter(item -> item.isNotNullItem() && item.isDaMayMan()).count() < 1 || player.combineNew.itemsCombine.size() == 4 && player.combineNew.itemsCombine.stream().filter(item -> item.isNotNullItem() && item.isDaMayMan()).count() < 1) {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Thiếu Đá may mắn", "Đóng");
                        return;
                    }
                    Item mTS = null, daNC = null, daMM = null;
                    for (Item item : player.combineNew.itemsCombine) {
                        if (item.isNotNullItem()) {
                            if (item.isManhTS()) {
                                mTS = item;
                            } else if (item.isDaNangCap()) {
                                daNC = item;
                            } else if (item.isDaMayMan()) {
                                daMM = item;
                            }
                        }
                    }
                    int tilemacdinh = 35;
                    int tilenew = tilemacdinh;
                    if (daNC != null) {
                        tilenew += (daNC.template.id - 1073) * 10;
                    }

                    String npcSay = "|2|Chế tạo " + player.combineNew.itemsCombine.stream().filter(Item::isManhTS).findFirst().get().typeNameManh() + " Thiên sứ "
                            + player.combineNew.itemsCombine.stream().filter(Item::isCongThucVip).findFirst().get().typeHanhTinh() + "\n"
                            + "|7|Mảnh ghép " + mTS.quantity + "/999\n";
//                            + "|2|Đá nâng cấp " + player.combineNew.itemsCombine.stream().filter(Item::isDaNangCap).findFirst().get().typeDanangcap()
//                            + " (+" + (daNC.template.id - 1073) + "0% tỉ lệ thành công)\n"
//                            + "|2|Đá may mắn " + player.combineNew.itemsCombine.stream().filter(Item::isDaMayMan).findFirst().get().typeDaMayman()
//                            + " (+" + (daMM.template.id - 1078) + "0% tỉ lệ tối đa các chỉ số)\n"
//                            + "|2|Tỉ lệ thành công: " + tilenew + "%\n"
//                            + "|7|Phí nâng cấp: 500 triệu vàng";

                    if (daNC != null) {

                        npcSay += "|2|Đá nâng cấp " + player.combineNew.itemsCombine.stream().filter(Item::isDaNangCap).findFirst().get().typeDanangcap()
                                + " (+" + (daNC.template.id - 1073) + "0% tỉ lệ thành công)\n";
                    }
                    if (daMM != null) {
                        npcSay += "|2|Đá may mắn " + player.combineNew.itemsCombine.stream().filter(Item::isDaMayMan).findFirst().get().typeDaMayman()
                                + " (+" + (daMM.template.id - 1078) + "0% tỉ lệ tối đa các chỉ số)\n";
                    }
                    if (daNC != null) {
                        npcSay += "|2|Tỉ lệ thành công: " + tilenew + "%\n";
                    } else {
                        npcSay += "|2|Tỉ lệ thành công: " + tilemacdinh + "%\n";
                    }
                    npcSay += "|7|Phí nâng cấp: 1 tỷ vàng và 20K Hồng Ngọc";
                    if (player.inventory.gold < 1000000000 || player.inventory.ruby < 20000) {
                        this.npsthiensu64.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Bạn không đủ vàng hoặc hồng ngọc", "Đóng");
                        return;
                    }
                    this.npsthiensu64.createOtherMenu(player, ConstNpc.MENU_START_COMBINE,
                            npcSay, "Nâng cấp\n1 Tỷ vàng", "Từ chối");
                } else {
                    if (player.combineNew.itemsCombine.size() > 4) {
                        this.npsthiensu64.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Nguyên liệu không phù hợp", "Đóng");
                        return;
                    }
                    this.npsthiensu64.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Không đủ nguyên liệu, mời quay lại sau", "Đóng");
                }
                break;

            case DOI_SKH_THANH_DNS:
                if (player.combineNew.itemsCombine.size() == 1) {
                    if (player.combineNew.itemsCombine.stream().filter(item -> item.isNotNullItem() && item.isSKH()).count() < 1) {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Thiếu đồ kích hoạt ", "Đóng");
                        return;
                    }
                    String npcSay = "Ngươi có muốn đổi một món đồ kích hoạt thành Đá Ngũ Sắc không ?\n";
                    if (player.inventory.gold >= COST_DOI_KICH_HOAT) {
                        this.baHatMit.createOtherMenu(player, ConstNpc.MENU_START_COMBINE, npcSay, "Tách SKH");
                    } else {
                        this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, npcSay, "Còn thiếu\n"
                                + Util.numberToMoney(player.inventory.gold - COST_DOI_KICH_HOAT) + " vàng");
                    }
                } else {
                    this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Ta cần đồ kích hoạt của ngươi", "Đóng");
                }

                break;

        }
    }

    /**
     * Bắt đầu đập đồ - điều hướng từng loại đập đồ
     *
     * @param player
     */
    public void startCombine(Player player) {
        switch (player.combineNew.typeCombine) {
            case MO_CHI_SO_CAI_TRANG:
                moChiSoCaiTrang(player);
                break;
            case DAP_SET_KICH_HOAT:
                dapDoKichHoat(player);
                break;
            case DAP_SET_KICH_HOAT_HD:
                dapDoKichHoatHD(player);
                break;
            case DAP_SET_KICH_HOAT_TS:
                dapDoKichHoatTS(player);
                break;
            case TAY_SKH_TRANG_BI:
                TaySKH(player);
                break;
            case NANG_HUY_DIET_LEN_SKH_VIP:
                huyDietLenKichHoatVIP(player);
                break;
            case KHAC_CHI_SO_DA:
                KhacChiSoDa(player);
                break;
            case KHAC_CHI_SO_NGOC_BOI:
                KhacChiSoTrangBi(player);
                break;
            case TIEN_HOA_NGOC_BOI:
                TienHoaNgocBoi(player);
                break;
            case THANG_CAP_TRANG_BI:
                ThangCapTrangBi(player);
                break;
            case EP_SAO_TRANG_BI:
                epSaoTrangBi(player);
                break;
            case EP_DA_DANH_HIEU:
                epDaDanhHieu(player);
                break;
            case EP_SAO_TRANG_BI_THANG_CAP:
                epSaoTrangBiTC(player);
                break;
            case PHA_LE_HOA_TRANG_BI:
                phaLeHoaTrangBi(player);
                break;

            case AN_TRANG_BI:
                antrangbi(player);
                break;
            case CHUYEN_HOA_TRANG_BI:

                break;
            case NHAP_NGOC_RONG:
                nhapNgocRong(player);
                break;

            case PHAN_RA_DO_THAN_LINH:
                phanradothanlinh(player);
                break;
            case NANG_CAP_DO_TS:
                openDTS(player);
                break;
            case NANG_CAP_SKH_VIP:
                openSKHVIP(player);
                break;
            case NANG_CAP_CAI_TRANG_SSJ:
                NangCapCaiTrangSSJ(player);
                break;
            case TIEN_HOA_CAI_TRANG_BABY_VEGETA:
                Tienhoacaitrangbaby(player);
                break;
            case TIEN_HOA_CAI_TRANG_BLACK_GOKU:
                Tienhoacaitrangblackgoku(player);
                break;
            case TIEN_HOA_CAI_TRANG_BILL:
                Tienhoacaitrangbill(player);
                break;
            case TIEN_HOA_CAI_TRANG_HEARTS_GOLD:
                Tienhoacaitranggold(player);
                break;
            case NANG_CAP_VAT_PHAM:
                nangCapVatPham(player);
                break;
            case EP_CHUNG_NHAN_XUAT_SU:
                EpChungNhanXuatSu(player);
                break;
            case NANG_CAP_CHAN_MENH:
                nangCapChanMenh(player);
                break;
            case NANG_CAP_BONG_TAI:
                nangCapBongTai(player);
                break;
            case MO_CHI_SO_BONG_TAI:
                moChiSoBongTai(player);
                break;
            case NANG_CAP_BONG_TAI_CAP3:
                nangCapBongTaicap3(player);
                break;
            case MO_CHI_SO_BONG_TAI_CAP3:
                moChiSoBongTaicap3(player);
                break;
            case NANG_CAP_BONG_TAI_CAP4:
                nangCapBongTaicap4(player);
                break;
            case MO_CHI_SO_BONG_TAI_CAP4:
                moChiSoBongTaicap4(player);
                break;
            case MO_CHI_SO_BI_TICH:
                moChiSoBiTich(player);
                break;
            case PS_HOA_TRANG_BI:
                psHoaTrangBi(player);
                break;
            case TINH_LUYEN_TRANG_BI:
                TinhLuyenTrangBi(player);
                break;
            case LUYEN_BI_TICH:
                LuyenBiTich(player);
                break;
            case TAY_PS_HOA_TRANG_BI:
                tayHacHoaTrangBi(player);
                break;
            case CHE_TAO_TRANG_BI_TS:
                cheTaoDoTS(player);
            case DOI_SKH_THANH_DNS:
                doiskhthanhdns(player);
                break;
            case DOI_DIEM:
                doidiem(player);
                break;
            // BKTTT _ SÁCH TUYỆT KỸ //
            case GIAM_DINH_SACH:
                giamDinhSach(player);
                break;
            case TAY_SACH:
                taySach(player);
                break;
            case NANG_CAP_SACH_TUYET_KY:
                nangCapSachTuyetKy(player);
                break;
            case PHUC_HOI_SACH:
                phucHoiSach(player);
                break;
            case PHAN_RA_SACH:
                phanRaSach(player);
                break;
        }

        player.iDMark.setIndexMenu(ConstNpc.IGNORE_MENU);
        player.combineNew.clearParamCombine();
        player.combineNew.lastTimeCombine = System.currentTimeMillis();

    }

    private void doidiem(Player player) {
        if (player.combineNew.itemsCombine.size() == 1) {
            player.inventory.gold -= 0;
            List<Integer> itemdov2 = new ArrayList<>(Arrays.asList(663, 664, 665, 666, 667));
            Item item = player.combineNew.itemsCombine.get(0);
            sendEffectSuccessCombine(player);
            if (item.quantity < 99) {
                Service.gI().sendThongBaoOK(player, "Đéo Đủ Thức Ăn");
            } else if (item.quantity >= 99) {
                InventoryServiceNew.gI().sendItemBags(player);
                player.inventory.coupon += 1;
                Service.gI().sendThongBaoOK(player, "Bú 1 Điểm");
                InventoryServiceNew.gI().subQuantityItemsBag(player, item, 99);
                player.combineNew.itemsCombine.clear();
                InventoryServiceNew.gI().sendItemBags(player);
                Service.gI().sendMoney(player);
                reOpenItemCombine(player);
            }
        }
    }

    public void moChiSoCaiTrang(Player player) {
        if (player.combineNew.itemsCombine.size() != 2) {
            Service.gI().sendThongBao(player, "Thiếu nguyên liệu");
            return;
        }
        if (player.combineNew.itemsCombine.stream()
                .filter(item -> item.isNotNullItem() && (item.template.type == 5))
                .count() != 1) {
            Service.gI().sendThongBao(player, "Thiếu cải trang");
            return;
        }
        if (player.combineNew.itemsCombine.stream().filter(item -> item.isNotNullItem() && item.template.id == 674)
                .count() != 1) {
            Service.gI().sendThongBao(player, "Thiếu lồng đèn");
            return;
        }
        ///

        Item caiTrang = null;
        Item longDen = null;
        int checkOption = 0;
        for (Item item : player.combineNew.itemsCombine) {
            if (item.template.type == 5) {
                caiTrang = item;
            } else if (item.template.id == 674) {
                longDen = item;
            }
        }
        for (Item.ItemOption io : caiTrang.itemOptions) {
            if (io.optionTemplate.id == 228) {
                checkOption++;
            } else if (io.optionTemplate.id == 229) {
                checkOption = 0;
            }
        }
        if (checkOption == 0) {
            Service.gI().sendThongBao(player, "Yêu cầu trang bị chưa kích hoạt ! ");
            return;
        }

        if (caiTrang != null && longDen != null && longDen.quantity >= 99) {
            InventoryServiceNew.gI().subQuantityItemsBag(player, longDen, 99);
            caiTrang.itemOptions.clear();
            caiTrang.itemOptions.add(new ItemOption(50, Util.nextInt(10, 40)));
            caiTrang.itemOptions.add(new ItemOption(77, Util.nextInt(15, 40)));
            caiTrang.itemOptions.add(new ItemOption(103, Util.nextInt(15, 40)));
            caiTrang.itemOptions.add(new ItemOption(14, Util.nextInt(5, 20)));
            caiTrang.itemOptions.add(new ItemOption(229, 0));
            caiTrang.itemOptions.add(new ItemOption(93, Util.nextInt(7, 14)));
            sendEffectSuccessCombine(player);
            InventoryServiceNew.gI().sendItemBags(player);
            Service.gI().sendMoney(player);
            reOpenItemCombine(player);
        } else {
            Service.gI().sendThongBao(player, "Không đủ nguyên liệu nâng cấp!");
            reOpenItemCombine(player);
        }
    }

    // START _ SÁCH TUYỆT KỸ
    private void giamDinhSach(Player player) {
        if (player.combineNew.itemsCombine.size() == 2) {

            Item sachTuyetKy = null;
            Item buaGiamDinh = null;
            for (Item item : player.combineNew.itemsCombine) {
                if (issachTuyetKy(item)) {
                    sachTuyetKy = item;
                } else if (item.template.id == 1554) {
                    buaGiamDinh = item;
                }
            }
            if (sachTuyetKy != null && buaGiamDinh != null) {
                Item sachTuyetKy_2 = ItemService.gI().createNewItem((short) sachTuyetKy.template.id);
                if (checkHaveOption(sachTuyetKy, 0, 233)) {
                    int tyle = new Random().nextInt(10);
                    if (tyle >= 0 && tyle <= 33) {
                        sachTuyetKy_2.itemOptions.add(new ItemOption(50, new Util().nextInt(5, 10)));
                    } else if (tyle > 33 && tyle <= 66) {
                        sachTuyetKy_2.itemOptions.add(new ItemOption(77, new Util().nextInt(10, 15)));
                    } else {
                        sachTuyetKy_2.itemOptions.add(new ItemOption(103, new Util().nextInt(10, 15)));
                    }
                    for (int i = 1; i < sachTuyetKy.itemOptions.size(); i++) {
                        sachTuyetKy_2.itemOptions.add(new ItemOption(sachTuyetKy.itemOptions.get(i).optionTemplate.id, sachTuyetKy.itemOptions.get(i).param));
                    }
                    sendEffectSuccessCombine(player);
                    InventoryServiceNew.gI().addItemBag(player, sachTuyetKy_2);
                    InventoryServiceNew.gI().subQuantityItemsBag(player, sachTuyetKy, 1);
                    InventoryServiceNew.gI().subQuantityItemsBag(player, buaGiamDinh, 1);
                    InventoryServiceNew.gI().sendItemBags(player);
                    reOpenItemCombine(player);
                } else {
                    Service.getInstance().sendThongBao(player, "Còn cái nịt mà giám");
                    return;
                }
            }
        }
    }

    private void nangCapSachTuyetKy(Player player) {
        if (player.combineNew.itemsCombine.size() == 2) {

            Item sachTuyetKy = null;
            Item kimBamGiay = null;

            for (Item item : player.combineNew.itemsCombine) {
                if (issachTuyetKy(item)) {
                    sachTuyetKy = item;
                } else if (item.template.id == 1553) {
                    kimBamGiay = item;
                }
            }
            Item sachTuyetKy_2 = ItemService.gI().createNewItem((short) ((short) sachTuyetKy.template.id + 1));
            if (sachTuyetKy != null && kimBamGiay != null) {
                if (kimBamGiay.quantity < 10) {
                    Service.getInstance().sendThongBao(player, "Không đủ Kìm bấm giấy mà đòi nâng cấp");
                    return;
                }
                if (checkHaveOption(sachTuyetKy, 0, 233)) {
                    Service.getInstance().sendThongBao(player, "Chưa giám định mà đòi nâng cấp");
                    return;
                }
                for (int i = 0; i < sachTuyetKy.itemOptions.size(); i++) {
                    sachTuyetKy_2.itemOptions.add(new ItemOption(sachTuyetKy.itemOptions.get(i).optionTemplate.id, sachTuyetKy.itemOptions.get(i).param));
                }
                sendEffectSuccessCombine(player);
                InventoryServiceNew.gI().addItemBag(player, sachTuyetKy_2);
                InventoryServiceNew.gI().subQuantityItemsBag(player, sachTuyetKy, 1);
                InventoryServiceNew.gI().subQuantityItemsBag(player, kimBamGiay, 10);
                InventoryServiceNew.gI().sendItemBags(player);
                reOpenItemCombine(player);

            }
        }
    }

    private void phucHoiSach(Player player) {
        if (player.combineNew.itemsCombine.size() == 1) {
            Item cuonSachCu = InventoryServiceNew.gI().findItemBag(player, (short) 1555);
            int goldPhanra = 10_000_000;
            Item sachTuyetKy = null;
            for (Item item : player.combineNew.itemsCombine) {
                if (issachTuyetKy(item)) {
                    sachTuyetKy = item;
                }
            }
            if (sachTuyetKy != null) {
                int doBen = 0;
                ItemOption optionLevel = null;
                for (ItemOption io : sachTuyetKy.itemOptions) {
                    if (io.optionTemplate.id == 231) {
                        doBen = io.param;
                        optionLevel = io;
                        break;
                    }
                }
                if (cuonSachCu == null) {
                    Service.getInstance().sendThongBaoOK(player, "Cần sách tuyệt kỹ và 10 cuốn sách cũ");
                    return;
                }
                if (cuonSachCu.quantity < 10) {
                    Service.getInstance().sendThongBaoOK(player, "Cần sách tuyệt kỹ và 10 cuốn sách cũ");
                    return;
                }
                if (player.inventory.gold < goldPhanra) {
                    Service.getInstance().sendThongBao(player, "Không có tiền mà đòi phục hồi à");
                    return;
                }
                if (doBen != 1000) {
                    for (int i = 0; i < sachTuyetKy.itemOptions.size(); i++) {
                        if (sachTuyetKy.itemOptions.get(i).optionTemplate.id == 231) {
                            sachTuyetKy.itemOptions.get(i).param = 1000;
                            break;
                        }
                    }
                    player.inventory.gold -= 10_000_000;
                    InventoryServiceNew.gI().subQuantityItemsBag(player, cuonSachCu, 10);
                    InventoryServiceNew.gI().sendItemBags(player);
                    Service.getInstance().sendMoney(player);
                    sendEffectSuccessCombine(player);
                    reOpenItemCombine(player);
                } else {
                    Service.getInstance().sendThongBao(player, "Còn dùng được phục hồi ăn cứt à");
                    return;
                }
            }
        }
    }

    private void phanRaSach(Player player) {
        if (player.combineNew.itemsCombine.size() == 1) {
            Item cuonSachCu = ItemService.gI().createNewItem((short) 1555, 5);
            int goldPhanra = 10_000_000;
            Item sachTuyetKy = null;
            for (Item item : player.combineNew.itemsCombine) {
                if (issachTuyetKy(item)) {
                    sachTuyetKy = item;
                }
            }
            if (sachTuyetKy != null) {
                int luotTay = 0;
                ItemOption optionLevel = null;
                for (ItemOption io : sachTuyetKy.itemOptions) {
                    if (io.optionTemplate.id == 230) {
                        luotTay = io.param;
                        optionLevel = io;
                        break;
                    }
                }
                if (player.inventory.gold < goldPhanra) {
                    Service.getInstance().sendThongBao(player, "Không có tiền mà đòi phân rã à");
                    return;
                }
                if (luotTay == 0) {

                    player.inventory.gold -= goldPhanra;
                    InventoryServiceNew.gI().subQuantityItemsBag(player, sachTuyetKy, 1);
                    InventoryServiceNew.gI().addItemBag(player, cuonSachCu);
                    InventoryServiceNew.gI().sendItemBags(player);
                    Service.getInstance().sendMoney(player);
                    sendEffectSuccessCombine(player);
                    reOpenItemCombine(player);

                } else {
                    Service.getInstance().sendThongBao(player, "Còn dùng được phân rã ăn cứt à");
                    return;
                }
            }
        }
    }

    private void taySach(Player player) {
        if (player.combineNew.itemsCombine.size() == 1) {
            Item sachTuyetKy = null;
            for (Item item : player.combineNew.itemsCombine) {
                if (issachTuyetKy(item)) {
                    sachTuyetKy = item;
                }
            }
            if (sachTuyetKy != null) {
                int luotTay = 0;
                ItemOption optionLevel = null;
                for (ItemOption io : sachTuyetKy.itemOptions) {
                    if (io.optionTemplate.id == 230) {
                        luotTay = io.param;
                        optionLevel = io;
                        break;
                    }
                }
                if (luotTay == 0) {
                    Service.getInstance().sendThongBao(player, "Còn cái nịt mà tẩy");
                    return;
                }
                Item sachTuyetKy_2 = ItemService.gI().createNewItem((short) sachTuyetKy.template.id);
                if (checkHaveOption(sachTuyetKy, 0, 233)) {
                    Service.getInstance().sendThongBao(player, "Còn cái nịt mà tẩy");
                    return;
                }
                int tyle = new Random().nextInt(10);
                for (int i = 1; i < sachTuyetKy.itemOptions.size(); i++) {
                    if (sachTuyetKy.itemOptions.get(i).optionTemplate.id == 230) {
                        sachTuyetKy.itemOptions.get(i).param -= 1;
                    }
                }
                sachTuyetKy_2.itemOptions.add(new ItemOption(233, 0));
                for (int i = 1; i < sachTuyetKy.itemOptions.size(); i++) {
                    sachTuyetKy_2.itemOptions.add(new ItemOption(sachTuyetKy.itemOptions.get(i).optionTemplate.id, sachTuyetKy.itemOptions.get(i).param));
                }
                sendEffectSuccessCombine(player);
                InventoryServiceNew.gI().addItemBag(player, sachTuyetKy_2);
                InventoryServiceNew.gI().subQuantityItemsBag(player, sachTuyetKy, 1);
                InventoryServiceNew.gI().sendItemBags(player);
                reOpenItemCombine(player);
            }
        }
    }
//---------------------- ĐẬP SÉT KÍCH HOẠT ĐỒ THẦN----------------------------------    

    private void dapDoKichHoat(Player player) {
        if (player.combineNew.itemsCombine.size() == 1 || player.combineNew.itemsCombine.size() == 2) {
            Item dhd = null, dtl = null;
            for (Item item : player.combineNew.itemsCombine) {
                if (item.isNotNullItem()) {
                    if (item.template.id >= 650 && item.template.id <= 662) {
                        dhd = item;
                    } else if (item.template.id >= 555 && item.template.id <= 567) {
                        dtl = item;
                    }
                }
            }
            if (dhd != null) {
                if (InventoryServiceNew.gI().getCountEmptyBag(player) > 0 //check chỗ trống hành trang
                        && player.inventory.gold >= COST_DAP_DO_KICH_HOAT) {
                    player.inventory.gold -= COST_DAP_DO_KICH_HOAT;
                    int tiLe = dtl != null ? 100 : 50;
                    if (Util.isTrue(tiLe, 100)) {
                        sendEffectSuccessCombine(player);
                        Item item = ItemService.gI().createNewItem((short) getTempIdItemC0(dhd.template.gender, dhd.template.type));
                        RewardService.gI().initBaseOptionClothes(item.template.id, item.template.type, item.itemOptions);
                        RewardService.gI().initActivationOption(item.template.gender < 3 ? item.template.gender : player.gender, item.template.type, item.itemOptions);
                        InventoryServiceNew.gI().addItemBag(player, item);
                    } else {
                        sendEffectFailCombine(player);
                    }
                    InventoryServiceNew.gI().subQuantityItemsBag(player, dhd, 1);
                    if (dtl != null) {
                        InventoryServiceNew.gI().subQuantityItemsBag(player, dtl, 1);
                    }
                    InventoryServiceNew.gI().sendItemBags(player);
                    Service.gI().sendMoney(player);
                    reOpenItemCombine(player);
                }
            }
        }
    }
//-------------------------------------------------------------------------------      

    private void dapDoKichHoatHD(Player player) {
        if (player.combineNew.itemsCombine.size() == 2) {
            Item dhd = null, dtl = null;
            for (Item item : player.combineNew.itemsCombine) {
                if (item.isNotNullItem()) {
                    if (item.template.id == 674) {
                        dtl = item;
                    } else if (item.template.id >= 650 && item.template.id <= 662) {
                        dhd = item;
                    }
                }
            }
            if (dhd != null) {
                if (InventoryServiceNew.gI().getCountEmptyBag(player) > 0 && player.inventory.gold >= COST_DAP_DO_KICH_HOAT && player.inventory.ruby >= RUBY_DAP_DO_KICH_HOAT && player.inventory.gem >= GEM_DAP_DO_KICH_HOAT) {
                    player.inventory.gold -= COST_DAP_DO_KICH_HOAT;
                    player.inventory.ruby -= RUBY_DAP_DO_KICH_HOAT;
                    player.inventory.gem -= GEM_DAP_DO_KICH_HOAT;
                    int tiLe = dtl != null ? 100 : 50;
                    if (Util.isTrue(tiLe, 100)) {
                        sendEffectSuccessCombine(player);
                        Item item = dhd;
                        RewardService.gI().initActivationOption(item.template.gender < 3 ? item.template.gender : player.gender, item.template.type, item.itemOptions);

                        InventoryServiceNew.gI().addItemBag(player, item);
                    } else {
                        sendEffectFailCombine(player);
                    }
                    InventoryServiceNew.gI().subQuantityItemsBag(player, dhd, 1);
                    if (dtl != null) {
                        InventoryServiceNew.gI().subQuantityItemsBag(player, dtl, 150);
                    }
                    InventoryServiceNew.gI().sendItemBags(player);
                    Service.gI().sendMoney(player);
                    reOpenItemCombine(player);
                }
            }
        }
    }

    private void dapDoKichHoatTS(Player player) {
        if (player.combineNew.itemsCombine.size() == 2) {
            Item dhd = null, dtl = null;
            for (Item item : player.combineNew.itemsCombine) {
                if (item.isNotNullItem()) {
                    if (item.template.id == 674) {
                        dtl = item;
                    } else if (item.template.id >= 1048 && item.template.id <= 1062) {
                        dhd = item;
                    }
                }
            }
            if (dhd != null) {
                if (InventoryServiceNew.gI().getCountEmptyBag(player) > 0 && player.inventory.gold >= COST_DAP_DO_KICH_HOAT && player.inventory.ruby >= RUBY_DAP_DO_KICH_HOAT && player.inventory.gem >= GEM_DAP_DO_KICH_HOAT) {
                    player.inventory.gold -= COST_DAP_DO_KICH_HOAT;
                    player.inventory.ruby -= RUBY_DAP_DO_KICH_HOAT;
                    player.inventory.gem -= GEM_DAP_DO_KICH_HOAT;
                    int tiLe = dtl != null ? 100 : 50;
                    if (Util.isTrue(tiLe, 100)) {
                        sendEffectSuccessCombine(player);
                        Item item = dhd;
                        RewardService.gI().initActivationOption(item.template.gender < 3 ? item.template.gender : player.gender, item.template.type, item.itemOptions);

                        InventoryServiceNew.gI().addItemBag(player, item);
                    } else {
                        sendEffectFailCombine(player);
                    }
                    InventoryServiceNew.gI().subQuantityItemsBag(player, dhd, 1);
                    if (dtl != null) {
                        InventoryServiceNew.gI().subQuantityItemsBag(player, dtl, 200);
                    }
                    InventoryServiceNew.gI().sendItemBags(player);
                    Service.gI().sendMoney(player);
                    reOpenItemCombine(player);
                }
            }
        }
    }

    public void huyDietLenKichHoatVIP(Player player) {
        if (player.combineNew.itemsCombine.size() != 3) {
            Service.gI().sendThongBao(player, "Sai nguyên liệu");
            return;
        }
        if (player.combineNew.itemsCombine.stream().filter(item -> item.isNotNullItem() && item.isDHD()).count() != 3) {
            Service.gI().sendThongBao(player, "Thiếu đồ huỷ diệt");
            return;
        }
        if (InventoryServiceNew.gI().getCountEmptyBag(player) > 0) {
            if (player.inventory.gold < 1) {
                Service.gI().sendThongBao(player, "Con cần thêm vàng để đổi...");
                return;
            }
            player.inventory.gold -= COST;
            Item dohdodayne = player.combineNew.itemsCombine.stream().filter(Item::isDHD).findFirst().get();
            List<Item> itemdohdlucbovao = player.combineNew.itemsCombine.stream().filter(item -> item.isNotNullItem() && item.isDHD()).collect(Collectors.toList());
            CombineServiceNew.gI().sendEffectOpenItem(player, dohdodayne.template.iconID, dohdodayne.template.iconID);
            short itemId;
            if (dohdodayne.template.gender == 3 || dohdodayne.template.type == 4) {
                itemId = Manager.radaSKHVip[0];
                if (player.getSession().bdPlayer > 0 && Util.isTrue(1, (int) (100 / player.getSession().bdPlayer))) {
                    itemId = Manager.radaSKHVip[0];
                }
            } else {
                itemId = Manager.doSKHVip[dohdodayne.template.gender][dohdodayne.template.type][0];
                if (player.getSession().bdPlayer > 0 && Util.isTrue(1, (int) (100 / player.getSession().bdPlayer))) {
                    itemId = Manager.doSKHVip[dohdodayne.template.gender][dohdodayne.template.type][0];
                }
            }
            int skhId = ItemService.gI().randomSKHId(player.gender);
            Item item = ItemService.gI().itemSKH(itemId, skhId);
            InventoryServiceNew.gI().addItemBag(player, item);
            InventoryServiceNew.gI().subQuantityItemsBag(player, dohdodayne, 1);
            itemdohdlucbovao.forEach(it -> InventoryServiceNew.gI().subQuantityItemsBag(player, it, 1));
            InventoryServiceNew.gI().sendItemBags(player);
            Service.gI().sendMoney(player);
            player.combineNew.itemsCombine.clear();
            reOpenItemCombine(player);
        } else {
            Service.gI().sendThongBao(player, "Bạn phải có ít nhất 1 ô trống hành trang");
        }
    }

    private void TaySKH(Player player) {
        if (player.combineNew.itemsCombine.size() == 2) {
            Item dhd = null, buatay = null;
            for (Item item : player.combineNew.itemsCombine) {
                if (item.isNotNullItem()) {
                    if (item.template.id == 674) {
                        buatay = item;
                    } else if (item.template.id >= 650 && item.template.id <= 662
                            || item.template.id >= 1048 && item.template.id <= 1062
                            || item.template.id >= 555 && item.template.id <= 567) {
                        dhd = item;
                    }
                }
            }
            int level = 0;
            int level2 = 0;
            int level3 = 0;
            Item.ItemOption optionLevel = null;
            Item.ItemOption optionLevel2 = null;
            Item.ItemOption optionLevel3 = null;
            for (Item.ItemOption io : dhd.itemOptions) {
                if (io.optionTemplate.id >= 127 && io.optionTemplate.id <= 135) {
                    level = io.param;
                    optionLevel = io;
                    break;
                }
            }
            for (Item.ItemOption io : dhd.itemOptions) {
                if (io.optionTemplate.id >= 136 && io.optionTemplate.id <= 144) {
                    level2 = io.param;
                    optionLevel2 = io;
                    break;
                }
            }
            for (Item.ItemOption io : dhd.itemOptions) {
                if (io.optionTemplate.id == 30) {
                    level3 = io.param;
                    optionLevel3 = io;
                    break;
                }
            }
            if (Util.isTrue(100, 100)) {

                if (dhd.isSKH() && optionLevel != null && optionLevel2 != null) {
                    dhd.itemOptions.remove(optionLevel);
                    dhd.itemOptions.remove(optionLevel2);
                    dhd.itemOptions.remove(optionLevel3);

                }
                sendEffectSuccessCombine(player);
                Service.getInstance().sendThongBao(player, "Bạn đã tẩy thành công");
                InventoryServiceNew.gI().sendItemBags(player);
            } else {
                sendEffectFailCombine(player);
            }
            InventoryServiceNew.gI().subQuantityItemsBag(player, buatay, 1);
            InventoryServiceNew.gI().sendItemBags(player);
            Service.getInstance().sendMoney(player);
            player.combineNew.itemsCombine.clear();
            reOpenItemCombine(player);
        }
    }

    private void KhacChiSoDa(Player player) {
        if (player.combineNew.itemsCombine.size() == 2) {
            Item ngocboi1 = null, DaKhac = null;
            for (Item item : player.combineNew.itemsCombine) {
                if (item.isNotNullItem()) {
                    if (item.isNotNullItem()) {
                        if (item.template.id == 1251) {
                            DaKhac = item;
                        } else if (item.template.id == 1248) {
                            ngocboi1 = item;
                        }
                    }
                }
            }
            int level1_1 = 0;
            int level1_2 = 0;
            int level1_3 = 0;
            int level1_4 = 0;
            int level1_72 = 0;
            int level1_102 = 0;
            int leve2_213 = 0;
            int leve2_217 = 0;
            Item.ItemOption optionLevel = null;
            Item.ItemOption optionLevel_102 = null;
            Item.ItemOption optionLeve2_213 = null;
            Item.ItemOption optionLeve2_217 = null;

            for (Item.ItemOption io : DaKhac.itemOptions) {
                if (io.optionTemplate.id == 213) { // Đã Điêu Khắc Chỉ Số
                    leve2_213 = io.param;
                    optionLeve2_213 = io;
                    break;
                }
            }
            for (Item.ItemOption io : DaKhac.itemOptions) {
                if (io.optionTemplate.id == 217) { // Đá Điêu Khắc Cấp
                    leve2_217 = io.param; // Số Cấp
                    optionLeve2_217 = io; // ID Option
                    break;
                }
            }

            for (Item.ItemOption io : ngocboi1.itemOptions) {
                if (io.optionTemplate.id == 72) {
                    level1_72 = io.param;
                    optionLevel = io;
                    break;
                }
            }
            for (Item.ItemOption io : ngocboi1.itemOptions) {
                if (io.optionTemplate.id == 102) {
                    level1_102 = io.param;
                    optionLevel_102 = io;
                    break;
                }
            }
            for (Item.ItemOption io : ngocboi1.itemOptions) {
                if (io.optionTemplate.id == 50) {
                    level1_1 = io.param;
                    break;
                }
            }
            for (Item.ItemOption io : ngocboi1.itemOptions) {
                if (io.optionTemplate.id == 77) {
                    level1_2 = io.param;
                    break;
                }
            }
            for (Item.ItemOption io : ngocboi1.itemOptions) {
                if (io.optionTemplate.id == 103) {
                    level1_3 = io.param;
                    break;
                }
            }
            for (Item.ItemOption io : ngocboi1.itemOptions) {
                if (io.optionTemplate.id == 5) {
                    level1_4 = io.param;
                    break;
                }
            }
            if (Util.isTrue(100, 100)) {
                if (player.inventory.ruby < 100000) {
                    Service.getInstance().sendThongBao(player, "Điêu Khắc Chỉ Số vào Đá tốn 100K Hồng Ngọc");
                    return;
                } else {
                    if (level1_72 == 0 && ngocboi1 != null && DaKhac != null && optionLeve2_213 == null && leve2_217 == 1 && optionLevel_102 == null) {
                        DaKhac.itemOptions.add(new ItemOption(50, level1_1 * 10 / 100));
                        DaKhac.itemOptions.add(new ItemOption(77, level1_2 * 10 / 100));
                        DaKhac.itemOptions.add(new ItemOption(103, level1_3 * 10 / 100));
                        DaKhac.itemOptions.add(new ItemOption(5, level1_4 * 10 / 100));
                        DaKhac.itemOptions.add(new ItemOption(213, 1));
                    }

                    if (level1_72 == 0 && ngocboi1 != null && DaKhac != null && optionLeve2_213 == null && leve2_217 == 2 && optionLevel_102 == null) {
                        DaKhac.itemOptions.add(new ItemOption(50, level1_1 * 15 / 100));
                        DaKhac.itemOptions.add(new ItemOption(77, level1_2 * 15 / 100));
                        DaKhac.itemOptions.add(new ItemOption(103, level1_3 * 15 / 100));
                        DaKhac.itemOptions.add(new ItemOption(5, level1_4 * 15 / 100));
                        DaKhac.itemOptions.add(new ItemOption(213, 1));
                    }

                    if (level1_72 == 0 && ngocboi1 != null && DaKhac != null && optionLeve2_213 == null && leve2_217 == 3 && optionLevel_102 == null) {
                        DaKhac.itemOptions.add(new ItemOption(50, level1_1 * 20 / 100));
                        DaKhac.itemOptions.add(new ItemOption(77, level1_2 * 20 / 100));
                        DaKhac.itemOptions.add(new ItemOption(103, level1_3 * 20 / 100));
                        DaKhac.itemOptions.add(new ItemOption(5, level1_4 * 20 / 100));
                        DaKhac.itemOptions.add(new ItemOption(213, 1));
                    }

                    if (level1_72 == 0 && ngocboi1 != null && DaKhac != null && optionLeve2_213 == null && leve2_217 == 4 && optionLevel_102 == null) {
                        DaKhac.itemOptions.add(new ItemOption(50, level1_1 * 25 / 100));
                        DaKhac.itemOptions.add(new ItemOption(77, level1_2 * 25 / 100));
                        DaKhac.itemOptions.add(new ItemOption(103, level1_3 * 25 / 100));
                        DaKhac.itemOptions.add(new ItemOption(5, level1_4 * 25 / 100));
                        DaKhac.itemOptions.add(new ItemOption(213, 1));
                    }
                    if (level1_72 == 0 && ngocboi1 != null && DaKhac != null && optionLeve2_213 == null && leve2_217 == 5 && optionLevel_102 == null) {
                        DaKhac.itemOptions.add(new ItemOption(50, level1_1 * 30 / 100));
                        DaKhac.itemOptions.add(new ItemOption(77, level1_2 * 30 / 100));
                        DaKhac.itemOptions.add(new ItemOption(103, level1_3 * 30 / 100));
                        DaKhac.itemOptions.add(new ItemOption(5, level1_4 * 30 / 100));
                        DaKhac.itemOptions.add(new ItemOption(213, 1));
                    }
                    if (level1_72 == 0 && ngocboi1 != null && DaKhac != null && optionLeve2_213 == null && leve2_217 == 6 && optionLevel_102 == null) {
                        DaKhac.itemOptions.add(new ItemOption(50, level1_1 * 35 / 100));
                        DaKhac.itemOptions.add(new ItemOption(77, level1_2 * 35 / 100));
                        DaKhac.itemOptions.add(new ItemOption(103, level1_3 * 35 / 100));
                        DaKhac.itemOptions.add(new ItemOption(5, level1_4 * 35 / 100));
                        DaKhac.itemOptions.add(new ItemOption(213, 1));
                    }

                    if (level1_72 == 0 && ngocboi1 != null && DaKhac != null && optionLeve2_213 == null && leve2_217 == 7 && optionLevel_102 == null) {
                        DaKhac.itemOptions.add(new ItemOption(50, level1_1 * 40 / 100));
                        DaKhac.itemOptions.add(new ItemOption(77, level1_2 * 40 / 100));
                        DaKhac.itemOptions.add(new ItemOption(103, level1_3 * 40 / 100));
                        DaKhac.itemOptions.add(new ItemOption(5, level1_4 * 40 / 100));
                        DaKhac.itemOptions.add(new ItemOption(213, 1));
                    }

                    if (level1_72 == 0 && ngocboi1 != null && DaKhac != null && optionLeve2_213 == null && leve2_217 == 8 && optionLevel_102 == null) {
                        DaKhac.itemOptions.add(new ItemOption(50, level1_1 * 45 / 100));
                        DaKhac.itemOptions.add(new ItemOption(77, level1_2 * 45 / 100));
                        DaKhac.itemOptions.add(new ItemOption(103, level1_3 * 45 / 100));
                        DaKhac.itemOptions.add(new ItemOption(5, level1_4 * 45 / 100));
                        DaKhac.itemOptions.add(new ItemOption(213, 1));
                    }

                    if (level1_72 == 0 && ngocboi1 != null && DaKhac != null && optionLeve2_213 == null && leve2_217 == 9 && optionLevel_102 == null) {
                        DaKhac.itemOptions.add(new ItemOption(50, level1_1 * 50 / 100));
                        DaKhac.itemOptions.add(new ItemOption(77, level1_2 * 50 / 100));
                        DaKhac.itemOptions.add(new ItemOption(103, level1_3 * 50 / 100));
                        DaKhac.itemOptions.add(new ItemOption(5, level1_4 * 50 / 100));
                        DaKhac.itemOptions.add(new ItemOption(213, 1));
                    }
                    if (level1_72 == 0 && ngocboi1 != null && DaKhac != null && optionLeve2_213 == null && leve2_217 == 10 && optionLevel_102 == null) {
                        DaKhac.itemOptions.add(new ItemOption(50, level1_1 * 55 / 100));
                        DaKhac.itemOptions.add(new ItemOption(77, level1_2 * 55 / 100));
                        DaKhac.itemOptions.add(new ItemOption(103, level1_3 * 55 / 100));
                        DaKhac.itemOptions.add(new ItemOption(5, level1_4 * 55 / 100));
                        DaKhac.itemOptions.add(new ItemOption(213, 1));
                    }
                    sendEffectSuccessCombine(player);
                    player.inventory.ruby -= 100000;
                    Service.getInstance().sendThongBao(player, "Bạn Điêu Khắc Chỉ Số vào Đá thành công");
                    InventoryServiceNew.gI().sendItemBags(player);
                }
            } else {
                sendEffectFailCombine(player);
            }
            InventoryServiceNew.gI().subQuantityItemsBag(player, ngocboi1, 1);
            InventoryServiceNew.gI().sendItemBags(player);
            Service.getInstance().sendMoney(player);
            player.combineNew.itemsCombine.clear();
            reOpenItemCombine(player);
        }
    }

    private void KhacChiSoTrangBi(Player player) {
        if (player.combineNew.itemsCombine.size() == 2) {
            Item ngocboi1 = null;
            Item DaKhac = null;
            for (Item item : player.combineNew.itemsCombine) {
                if (item.isNotNullItem()) {
                    if (item.isNotNullItem()) {
                        if (item.template.id == 1251) {
                            DaKhac = item;
                        } else if (item.template.id == 1248
                                || item.template.id == 1253
                                || item.template.id == 1254
                                || item.template.id == 1255
                                || item.template.id == 1256
                                || item.template.id == 1257) {
                            ngocboi1 = item;
                        }
                    }
                }
            }

            int level1_1 = 0;
            int level1_2 = 0;
            int level1_3 = 0;
            int level1_4 = 0;
            int level2_1 = 0;
            int level2_2 = 0;
            int level2_3 = 0;
            int level2_4 = 0;
            int level3_1 = 0;
            int level3_2 = 0;
            int level3_3 = 0;
            int level3_4 = 0;
            int level1_72 = 0;
            int leve2_213 = 0;
            int leve2_217 = 0;
            Item.ItemOption optionLevel = null;
            Item.ItemOption optionLevel_5 = null;
            Item.ItemOption optionLevel_50 = null;
            Item.ItemOption optionLevel_77 = null;
            Item.ItemOption optionLevel_103 = null;
            Item.ItemOption optionLeve2_213 = null;
            Item.ItemOption optionLeve2_217 = null;

            for (Item.ItemOption io : DaKhac.itemOptions) {
                if (io.optionTemplate.id == 213) { // Đã Điêu Khắc Chỉ Số
                    leve2_213 = io.param;
                    optionLeve2_213 = io;
                    break;
                }
            }
            for (Item.ItemOption io : DaKhac.itemOptions) {
                if (io.optionTemplate.id == 217) { // Đá Điêu Khắc Cấp
                    leve2_217 = io.param; // Số Cấp
                    optionLeve2_217 = io; // ID Option
                    break;
                }
            }

            for (Item.ItemOption io : ngocboi1.itemOptions) {
                if (io.optionTemplate.id == 72) {
                    level1_72 = io.param;
                    optionLevel = io;
                    break;
                }
            }
            for (Item.ItemOption io : ngocboi1.itemOptions) {
                if (io.optionTemplate.id == 50) {
                    level1_1 = io.param;
                    optionLevel_50 = io;
                    break;
                }
            }
            for (Item.ItemOption io : ngocboi1.itemOptions) {
                if (io.optionTemplate.id == 77) {
                    level1_2 = io.param;
                    optionLevel_77 = io;
                    break;
                }
            }
            for (Item.ItemOption io : ngocboi1.itemOptions) {
                if (io.optionTemplate.id == 103) {
                    level1_3 = io.param;
                    optionLevel_103 = io;
                    break;
                }
            }
            for (Item.ItemOption io : ngocboi1.itemOptions) {
                if (io.optionTemplate.id == 5) {
                    level1_4 = io.param;
                    optionLevel_5 = io;
                    break;
                }
            }
            for (ItemOption io : DaKhac.itemOptions) {
                if (io.optionTemplate.id == 50) {
                    level2_1 = io.param;

                    break;
                }
            }
            for (ItemOption io : DaKhac.itemOptions) {
                if (io.optionTemplate.id == 77) {
                    level2_2 = io.param;

                    break;
                }
            }
            for (ItemOption io : DaKhac.itemOptions) {
                if (io.optionTemplate.id == 103) {
                    level2_3 = io.param;

                    break;
                }
            }
            for (ItemOption io : DaKhac.itemOptions) {
                if (io.optionTemplate.id == 5) {
                    level2_4 = io.param;

                    break;
                }
            }

//                if (ngocboi1 != null) {
//                for (ItemOption itopt : ngocboi1.itemOptions) {
//                    if (itopt.optionTemplate.id == 72) {
//                        if (itopt.param >= 10) {
//                            Service.getInstance().sendThongBao(player, "Trang bị đã Điêu Khắc tối đa");
//                            return;
//                        }
//                    }
//                }
//            }           
            if (optionLevel != null && level1_72 == 10) {
                Service.getInstance().sendThongBao(player, "Đã Điêu Khắc Trang Bị tối da");
                return;
            }
            if (Util.isTrue(100, 100)) {
                if (player.inventory.ruby < 100000) {
                    Service.getInstance().sendThongBao(player, "Điêu Khắc Chỉ Số vào Đá tốn 100K Hồng Ngọc");
                    return;
                } else {
                    if (optionLevel == null && ngocboi1 != null && DaKhac != null && optionLeve2_213 != null) {
                        if (leve2_217 > 1) {
                            Service.getInstance().sendThongBao(player, "Đá Điêu Khắc không phù hợp!\n Hãy dùng Đá Điêu Khắc Chỉ Số Cấp 1");
                            return;
                        } else {
                            ngocboi1.itemOptions.remove(optionLevel_50);
                            ngocboi1.itemOptions.remove(optionLevel_77);
                            ngocboi1.itemOptions.remove(optionLevel_103);
                            ngocboi1.itemOptions.remove(optionLevel_5);

                            ngocboi1.itemOptions.add(new ItemOption(50, (level1_1 + level2_1)));
                            ngocboi1.itemOptions.add(new ItemOption(77, level1_2 + level2_2));
                            ngocboi1.itemOptions.add(new ItemOption(103, level1_3 + level2_3));
                            ngocboi1.itemOptions.add(new ItemOption(5, level1_4 + level2_4));
                            ngocboi1.itemOptions.add(new ItemOption(72, 1));
                        }
                    }

                    if (optionLevel != null && ngocboi1 != null && DaKhac != null && optionLeve2_213 != null && level1_72 == 1) {
                        if (leve2_217 > 2 || leve2_217 < 2) {
                            Service.getInstance().sendThongBao(player, "Đá Điêu Khắc không phù hợp!\n Hãy dùng Đá Điêu Khắc Chỉ Số Cấp 2");
                            return;
                        } else {
                            ngocboi1.itemOptions.remove(optionLevel_50);
                            ngocboi1.itemOptions.remove(optionLevel_77);
                            ngocboi1.itemOptions.remove(optionLevel_103);
                            ngocboi1.itemOptions.remove(optionLevel_5);
                            ngocboi1.itemOptions.remove(optionLevel);

                            ngocboi1.itemOptions.add(new ItemOption(50, (level1_1 + level2_1)));
                            ngocboi1.itemOptions.add(new ItemOption(77, level1_2 + level2_2));
                            ngocboi1.itemOptions.add(new ItemOption(103, level1_3 + level2_3));
                            ngocboi1.itemOptions.add(new ItemOption(5, level1_4 + level2_4));
                            ngocboi1.itemOptions.add(new ItemOption(72, 2));
                        }
                    }

                    if (optionLevel != null && ngocboi1 != null && DaKhac != null && optionLeve2_213 != null && level1_72 == 2) {
                        if (leve2_217 > 3 || leve2_217 < 3) {
                            Service.getInstance().sendThongBao(player, "Đá Điêu Khắc không phù hợp!\n Hãy dùng Đá Điêu Khắc Chỉ Số Cấp 3");
                            return;
                        } else {
                            ngocboi1.itemOptions.remove(optionLevel_50);
                            ngocboi1.itemOptions.remove(optionLevel_77);
                            ngocboi1.itemOptions.remove(optionLevel_103);
                            ngocboi1.itemOptions.remove(optionLevel_5);
                            ngocboi1.itemOptions.remove(optionLevel);

                            ngocboi1.itemOptions.add(new ItemOption(50, (level1_1 + level2_1)));
                            ngocboi1.itemOptions.add(new ItemOption(77, level1_2 + level2_2));
                            ngocboi1.itemOptions.add(new ItemOption(103, level1_3 + level2_3));
                            ngocboi1.itemOptions.add(new ItemOption(5, level1_4 + level2_4));
                            ngocboi1.itemOptions.add(new ItemOption(72, 3));
                        }
                    }

                    if (optionLevel != null && ngocboi1 != null && DaKhac != null && optionLeve2_213 != null && level1_72 == 3) {
                        if (leve2_217 > 4 || leve2_217 < 4) {
                            Service.getInstance().sendThongBao(player, "Đá Điêu Khắc không phù hợp!\n Hãy dùng Đá Điêu Khắc Chỉ Số Cấp 4");
                            return;
                        } else {
                            ngocboi1.itemOptions.remove(optionLevel_50);
                            ngocboi1.itemOptions.remove(optionLevel_77);
                            ngocboi1.itemOptions.remove(optionLevel_103);
                            ngocboi1.itemOptions.remove(optionLevel_5);
                            ngocboi1.itemOptions.remove(optionLevel);

                            ngocboi1.itemOptions.add(new ItemOption(50, (level1_1 + level2_1)));
                            ngocboi1.itemOptions.add(new ItemOption(77, level1_2 + level2_2));
                            ngocboi1.itemOptions.add(new ItemOption(103, level1_3 + level2_3));
                            ngocboi1.itemOptions.add(new ItemOption(5, level1_4 + level2_4));
                            ngocboi1.itemOptions.add(new ItemOption(72, 4));
                        }
                    }
                    if (optionLevel != null && ngocboi1 != null && DaKhac != null && optionLeve2_213 != null && level1_72 == 4) {
                        if (leve2_217 > 5 || leve2_217 < 5) {
                            Service.getInstance().sendThongBao(player, "Đá Điêu Khắc không phù hợp!\n Hãy dùng Đá Điêu Khắc Chỉ Số Cấp 5");
                            return;
                        } else {
                            ngocboi1.itemOptions.remove(optionLevel_50);
                            ngocboi1.itemOptions.remove(optionLevel_77);
                            ngocboi1.itemOptions.remove(optionLevel_103);
                            ngocboi1.itemOptions.remove(optionLevel_5);
                            ngocboi1.itemOptions.remove(optionLevel);

                            ngocboi1.itemOptions.add(new ItemOption(50, (level1_1 + level2_1)));
                            ngocboi1.itemOptions.add(new ItemOption(77, level1_2 + level2_2));
                            ngocboi1.itemOptions.add(new ItemOption(103, level1_3 + level2_3));
                            ngocboi1.itemOptions.add(new ItemOption(5, level1_4 + level2_4));
                            ngocboi1.itemOptions.add(new ItemOption(72, 5));
                        }
                    }
                    if (optionLevel != null && ngocboi1 != null && DaKhac != null && optionLeve2_213 != null && level1_72 == 5) {
                        if (leve2_217 > 6 || leve2_217 < 6) {
                            Service.getInstance().sendThongBao(player, "Đá Điêu Khắc không phù hợp!\n Hãy dùng Đá Điêu Khắc Chỉ Số Cấp 6");
                            return;
                        } else {
                            ngocboi1.itemOptions.remove(optionLevel_50);
                            ngocboi1.itemOptions.remove(optionLevel_77);
                            ngocboi1.itemOptions.remove(optionLevel_103);
                            ngocboi1.itemOptions.remove(optionLevel_5);
                            ngocboi1.itemOptions.remove(optionLevel);

                            ngocboi1.itemOptions.add(new ItemOption(50, (level1_1 + level2_1)));
                            ngocboi1.itemOptions.add(new ItemOption(77, level1_2 + level2_2));
                            ngocboi1.itemOptions.add(new ItemOption(103, level1_3 + level2_3));
                            ngocboi1.itemOptions.add(new ItemOption(5, level1_4 + level2_4));
                            ngocboi1.itemOptions.add(new ItemOption(72, 6));
                        }
                    }

                    if (optionLevel != null && ngocboi1 != null && DaKhac != null && optionLeve2_213 != null && level1_72 == 6) {
                        if (leve2_217 > 7 || leve2_217 < 7) {
                            Service.getInstance().sendThongBao(player, "Đá Điêu Khắc không phù hợp!\n Hãy dùng Đá Điêu Khắc Chỉ Số Cấp 7");
                            return;
                        } else {
                            ngocboi1.itemOptions.remove(optionLevel_50);
                            ngocboi1.itemOptions.remove(optionLevel_77);
                            ngocboi1.itemOptions.remove(optionLevel_103);
                            ngocboi1.itemOptions.remove(optionLevel_5);
                            ngocboi1.itemOptions.remove(optionLevel);

                            ngocboi1.itemOptions.add(new ItemOption(50, (level1_1 + level2_1)));
                            ngocboi1.itemOptions.add(new ItemOption(77, level1_2 + level2_2));
                            ngocboi1.itemOptions.add(new ItemOption(103, level1_3 + level2_3));
                            ngocboi1.itemOptions.add(new ItemOption(5, level1_4 + level2_4));
                            ngocboi1.itemOptions.add(new ItemOption(72, 7));
                        }
                    }

                    if (optionLevel != null && ngocboi1 != null && DaKhac != null && optionLeve2_213 != null && level1_72 == 7) {
                        if (leve2_217 > 8 || leve2_217 < 8) {
                            Service.getInstance().sendThongBao(player, "Đá Điêu Khắc không phù hợp!\n Hãy dùng Đá Điêu Khắc Chỉ Số Cấp 8");
                            return;
                        } else {
                            ngocboi1.itemOptions.remove(optionLevel_50);
                            ngocboi1.itemOptions.remove(optionLevel_77);
                            ngocboi1.itemOptions.remove(optionLevel_103);
                            ngocboi1.itemOptions.remove(optionLevel_5);
                            ngocboi1.itemOptions.remove(optionLevel);

                            ngocboi1.itemOptions.add(new ItemOption(50, (level1_1 + level2_1)));
                            ngocboi1.itemOptions.add(new ItemOption(77, level1_2 + level2_2));
                            ngocboi1.itemOptions.add(new ItemOption(103, level1_3 + level2_3));
                            ngocboi1.itemOptions.add(new ItemOption(5, level1_4 + level2_4));
                            ngocboi1.itemOptions.add(new ItemOption(72, 8));
                        }
                    }

                    if (optionLevel != null && ngocboi1 != null && DaKhac != null && optionLeve2_213 != null && level1_72 == 8) {
                        if (leve2_217 > 9 || leve2_217 < 9) {
                            Service.getInstance().sendThongBao(player, "Đá Điêu Khắc không phù hợp!\n Hãy dùng Đá Điêu Khắc Chỉ Số Cấp 9");
                            return;
                        } else {
                            ngocboi1.itemOptions.remove(optionLevel_50);
                            ngocboi1.itemOptions.remove(optionLevel_77);
                            ngocboi1.itemOptions.remove(optionLevel_103);
                            ngocboi1.itemOptions.remove(optionLevel_5);
                            ngocboi1.itemOptions.remove(optionLevel);

                            ngocboi1.itemOptions.add(new ItemOption(50, (level1_1 + level2_1)));
                            ngocboi1.itemOptions.add(new ItemOption(77, level1_2 + level2_2));
                            ngocboi1.itemOptions.add(new ItemOption(103, level1_3 + level2_3));
                            ngocboi1.itemOptions.add(new ItemOption(5, level1_4 + level2_4));
                            ngocboi1.itemOptions.add(new ItemOption(72, 9));
                        }
                    }
                    if (optionLevel != null && ngocboi1 != null && DaKhac != null && optionLeve2_213 != null && level1_72 == 9) {
                        if (leve2_217 > 10 || leve2_217 < 10) {
                            Service.getInstance().sendThongBao(player, "Đá Điêu Khắc không phù hợp!\n Hãy dùng Đá Điêu Khắc Chỉ Số Cấp 10");
                            return;
                        } else {
                            ngocboi1.itemOptions.remove(optionLevel_50);
                            ngocboi1.itemOptions.remove(optionLevel_77);
                            ngocboi1.itemOptions.remove(optionLevel_103);
                            ngocboi1.itemOptions.remove(optionLevel_5);
                            ngocboi1.itemOptions.remove(optionLevel);

                            ngocboi1.itemOptions.add(new ItemOption(50, (level1_1 + level2_1)));
                            ngocboi1.itemOptions.add(new ItemOption(77, level1_2 + level2_2));
                            ngocboi1.itemOptions.add(new ItemOption(103, level1_3 + level2_3));
                            ngocboi1.itemOptions.add(new ItemOption(5, level1_4 + level2_4));
                            ngocboi1.itemOptions.add(new ItemOption(72, 10));
                        }
                    }
                }
                Service.getInstance().sendThongBao(player, "Bạn Điêu Khắc Chỉ Số vào Ngọc Bội thành công");
                player.inventory.ruby -= 100000;
                sendEffectSuccessCombine(player);
                InventoryServiceNew.gI().subQuantityItemsBag(player, DaKhac, 1);
                InventoryServiceNew.gI().sendItemBags(player);
                Service.getInstance().sendMoney(player);
                player.combineNew.itemsCombine.clear();
                reOpenItemCombine(player);
            }
        }
    }

    private void TienHoaNgocBoi(Player player) {
        if (player.combineNew.itemsCombine.size() == 2) {
            Item ngocboi1 = null;
            Item DaKhac = null;
            for (Item item : player.combineNew.itemsCombine) {
                if (item.isNotNullItem()) {
                    if (item.isNotNullItem()) {
                        if (item.template.id == 1258) {
                            DaKhac = item;
                        } else if (item.template.id == 1248
                                || item.template.id == 1253
                                || item.template.id == 1254
                                || item.template.id == 1255
                                || item.template.id == 1256
                                || item.template.id == 1257) {
                            ngocboi1 = item;
                        }
                    }
                }
            }

            int level1_1 = 0;
            int level1_2 = 0;
            int level1_3 = 0;
            int level1_4 = 0;
            int level1_72 = 0;
            int level1_102 = 0;
            int level1_219 = 0;
            int level1_220 = 0;
            int level1_221 = 0;
            int level1_222 = 0;
            int level1_223 = 0;
            int level1_107 = 0;

            Item.ItemOption optionLevel_72 = null;
            Item.ItemOption optionLevel_5 = null;
            Item.ItemOption optionLevel_50 = null;
            Item.ItemOption optionLevel_77 = null;
            Item.ItemOption optionLevel_103 = null;
            Item.ItemOption optionLevel_102 = null;
            Item.ItemOption optionLevel_219 = null;
            Item.ItemOption optionLevel_220 = null;
            Item.ItemOption optionLevel_221 = null;
            Item.ItemOption optionLevel_222 = null;
            Item.ItemOption optionLevel_223 = null;
            Item.ItemOption optionLevel_107 = null;

            for (Item.ItemOption io : ngocboi1.itemOptions) {
                if (io.optionTemplate.id == 72) {
                    level1_72 = io.param;
                    optionLevel_72 = io;
                    break;
                }
            }
            for (Item.ItemOption io : ngocboi1.itemOptions) {
                if (io.optionTemplate.id == 102) {
                    level1_102 = io.param;
                    optionLevel_102 = io;
                    break;
                }
            }
            for (Item.ItemOption io : ngocboi1.itemOptions) {
                if (io.optionTemplate.id == 107) {
                    level1_107 = io.param;
                    optionLevel_107 = io;
                    break;
                }
            }
            for (Item.ItemOption io : ngocboi1.itemOptions) {
                if (io.optionTemplate.id == 219) {
                    level1_219 = io.param;
                    optionLevel_219 = io;
                    break;
                }
            }
            for (Item.ItemOption io : ngocboi1.itemOptions) {
                if (io.optionTemplate.id == 220) {
                    level1_220 = io.param;
                    optionLevel_220 = io;
                    break;
                }
            }
            for (Item.ItemOption io : ngocboi1.itemOptions) {
                if (io.optionTemplate.id == 223) {
                    level1_223 = io.param;
                    optionLevel_223 = io;
                    break;
                }
            }
            for (Item.ItemOption io : ngocboi1.itemOptions) {
                if (io.optionTemplate.id == 221) {
                    level1_221 = io.param;
                    optionLevel_221 = io;
                    break;
                }
            }
            for (Item.ItemOption io : ngocboi1.itemOptions) {
                if (io.optionTemplate.id == 222) {
                    level1_222 = io.param;
                    optionLevel_222 = io;
                    break;
                }
            }
            for (Item.ItemOption io : ngocboi1.itemOptions) {
                if (io.optionTemplate.id == 50) {
                    level1_1 = io.param;
                    optionLevel_50 = io;
                    break;
                }
            }
            for (Item.ItemOption io : ngocboi1.itemOptions) {
                if (io.optionTemplate.id == 77) {
                    level1_2 = io.param;
                    optionLevel_77 = io;
                    break;
                }
            }
            for (Item.ItemOption io : ngocboi1.itemOptions) {
                if (io.optionTemplate.id == 103) {
                    level1_3 = io.param;
                    optionLevel_103 = io;
                    break;
                }
            }
            for (Item.ItemOption io : ngocboi1.itemOptions) {
                if (io.optionTemplate.id == 5) {
                    level1_4 = io.param;
                    optionLevel_5 = io;
                    break;
                }
            }

            if (ngocboi1.template.id == 1257 && level1_72 == 10) {
                Service.getInstance().sendThongBao(player, "Ngọc Bội Đã Tiến Hóa Tối Đa");
                return;
            }

            if (ngocboi1 == null || DaKhac == null) {
                Service.getInstance().sendThongBao(player, "Không đủ vật phẩm để Tiến Hóa Ngọc Bội");
                return;
            }
            if (Util.isTrue(100, 100)) {
                if (player.inventory.ruby > 500000 || player.inventory.gold > 50_000_000_000L) {

                    if (ngocboi1.template.id == 1248 && level1_72 == 10 && DaKhac.quantity >= 1) {

                        InventoryServiceNew.gI().subQuantityItemsBag(player, DaKhac, 1);
                        InventoryServiceNew.gI().subQuantityItemsBag(player, ngocboi1, 1);

                        Item item = ItemService.gI().createNewItem((short) 1253);
                        item.itemOptions.add(new Item.ItemOption(50, level1_1 + 20));
                        item.itemOptions.add(new Item.ItemOption(77, level1_2 + 20));
                        item.itemOptions.add(new Item.ItemOption(103, level1_3 + 20));
                        item.itemOptions.add(new Item.ItemOption(5, level1_4 + 10));
                        item.itemOptions.add(new Item.ItemOption(107, level1_107));
                        item.itemOptions.add(new Item.ItemOption(102, level1_102));

                        if (optionLevel_223 != null) {
                            item.itemOptions.add(new Item.ItemOption(223, level1_223));
                            item.itemOptions.add(new Item.ItemOption(219, level1_219));
                            item.itemOptions.add(new Item.ItemOption(220, level1_220));
                            item.itemOptions.add(new Item.ItemOption(221, level1_221));
                            item.itemOptions.add(new Item.ItemOption(222, level1_222));

                        }

                        InventoryServiceNew.gI().addItemBag(player, item);
                        Service.getInstance().sendThongBao(player, "Bạn đã Tiến Hóa Ngọc Bội thành công");
                        player.inventory.ruby -= 500000;
                        player.inventory.gold -= 50_000_000_000L;
                        sendEffectSuccessCombine(player);

                        InventoryServiceNew.gI().sendItemBags(player);
                        Service.getInstance().sendMoney(player);
                        player.combineNew.itemsCombine.clear();
                        reOpenItemCombine(player);
                        return;
                    }

                    if (ngocboi1.template.id == 1253 && level1_72 == 10 && DaKhac.quantity >= 2) {

                        InventoryServiceNew.gI().subQuantityItemsBag(player, DaKhac, 2);
                        InventoryServiceNew.gI().subQuantityItemsBag(player, ngocboi1, 1);

                        Item item = ItemService.gI().createNewItem((short) 1254);
                        item.itemOptions.add(new Item.ItemOption(50, level1_1 + 30));
                        item.itemOptions.add(new Item.ItemOption(77, level1_2 + 30));
                        item.itemOptions.add(new Item.ItemOption(103, level1_3 + 30));
                        item.itemOptions.add(new Item.ItemOption(5, level1_4 + 15));
                        item.itemOptions.add(new Item.ItemOption(107, level1_107));
                        item.itemOptions.add(new Item.ItemOption(102, level1_102));

                        if (optionLevel_223 != null) {
                            item.itemOptions.add(new Item.ItemOption(223, level1_223));
                            item.itemOptions.add(new Item.ItemOption(219, level1_219));
                            item.itemOptions.add(new Item.ItemOption(220, level1_220));
                            item.itemOptions.add(new Item.ItemOption(221, level1_221));
                            item.itemOptions.add(new Item.ItemOption(222, level1_222));
                        }

                        InventoryServiceNew.gI().addItemBag(player, item);
                        Service.getInstance().sendThongBao(player, "Bạn đã Tiến Hóa Ngọc Bội thành công");
                        player.inventory.ruby -= 500000;
                        player.inventory.gold -= 50_000_000_000L;
                        sendEffectSuccessCombine(player);

                        InventoryServiceNew.gI().sendItemBags(player);
                        Service.getInstance().sendMoney(player);
                        player.combineNew.itemsCombine.clear();
                        reOpenItemCombine(player);
                        return;
                    }

                    if (ngocboi1.template.id == 1254 && level1_72 == 10 && DaKhac.quantity >= 3) {

                        InventoryServiceNew.gI().subQuantityItemsBag(player, DaKhac, 3);
                        InventoryServiceNew.gI().subQuantityItemsBag(player, ngocboi1, 1);

                        Item item = ItemService.gI().createNewItem((short) 1255);
                        item.itemOptions.add(new Item.ItemOption(50, level1_1 + 45));
                        item.itemOptions.add(new Item.ItemOption(77, level1_2 + 45));
                        item.itemOptions.add(new Item.ItemOption(103, level1_3 + 45));
                        item.itemOptions.add(new Item.ItemOption(5, level1_4 + 20));
                        item.itemOptions.add(new Item.ItemOption(107, level1_107));
                        item.itemOptions.add(new Item.ItemOption(102, level1_102));

                        if (optionLevel_223 != null) {
                            item.itemOptions.add(new Item.ItemOption(223, level1_223));
                            item.itemOptions.add(new Item.ItemOption(219, level1_219));
                            item.itemOptions.add(new Item.ItemOption(220, level1_220));
                            item.itemOptions.add(new Item.ItemOption(221, level1_221));
                            item.itemOptions.add(new Item.ItemOption(222, level1_222));
                        }
                        InventoryServiceNew.gI().addItemBag(player, item);
                        Service.getInstance().sendThongBao(player, "Bạn đã Tiến Hóa Ngọc Bội thành công");
                        player.inventory.ruby -= 500000;
                        player.inventory.gold -= 50_000_000_000L;
                        sendEffectSuccessCombine(player);

                        InventoryServiceNew.gI().sendItemBags(player);
                        Service.getInstance().sendMoney(player);
                        player.combineNew.itemsCombine.clear();
                        reOpenItemCombine(player);
                        return;
                    }

                    if (ngocboi1.template.id == 1255 && level1_72 == 10 && DaKhac.quantity >= 4) {

                        InventoryServiceNew.gI().subQuantityItemsBag(player, DaKhac, 4);
                        InventoryServiceNew.gI().subQuantityItemsBag(player, ngocboi1, 1);

                        Item item = ItemService.gI().createNewItem((short) 1256);
                        item.itemOptions.add(new Item.ItemOption(50, level1_1 + 70));
                        item.itemOptions.add(new Item.ItemOption(77, level1_2 + 70));
                        item.itemOptions.add(new Item.ItemOption(103, level1_3 + 70));
                        item.itemOptions.add(new Item.ItemOption(5, level1_4 + 35));
                        item.itemOptions.add(new Item.ItemOption(107, level1_107));
                        item.itemOptions.add(new Item.ItemOption(102, level1_102));

                        if (optionLevel_223 != null) {
                            item.itemOptions.add(new Item.ItemOption(223, level1_223));
                            item.itemOptions.add(new Item.ItemOption(219, level1_219));
                            item.itemOptions.add(new Item.ItemOption(220, level1_220));
                            item.itemOptions.add(new Item.ItemOption(221, level1_221));
                            item.itemOptions.add(new Item.ItemOption(222, level1_222));
                        }
                        InventoryServiceNew.gI().addItemBag(player, item);
                        Service.getInstance().sendThongBao(player, "Bạn đã Tiến Hóa Ngọc Bội thành công");
                        player.inventory.ruby -= 500000;
                        player.inventory.gold -= 50_000_000_000L;
                        sendEffectSuccessCombine(player);

                        InventoryServiceNew.gI().sendItemBags(player);
                        Service.getInstance().sendMoney(player);
                        player.combineNew.itemsCombine.clear();
                        reOpenItemCombine(player);
                        return;

                    }

                    if (ngocboi1.template.id == 1256 && level1_72 == 10 && DaKhac.quantity >= 5) {

                        InventoryServiceNew.gI().subQuantityItemsBag(player, DaKhac, 5);
                        InventoryServiceNew.gI().subQuantityItemsBag(player, ngocboi1, 1);

                        Item item = ItemService.gI().createNewItem((short) 1257);
                        item.itemOptions.add(new Item.ItemOption(50, level1_1 + 100));
                        item.itemOptions.add(new Item.ItemOption(77, level1_2 + 100));
                        item.itemOptions.add(new Item.ItemOption(103, level1_3 + 100));
                        item.itemOptions.add(new Item.ItemOption(5, level1_4 + 50));
                        item.itemOptions.add(new Item.ItemOption(107, level1_107));
                        item.itemOptions.add(new Item.ItemOption(102, level1_102));

                        if (optionLevel_223 != null) {
                            item.itemOptions.add(new Item.ItemOption(223, level1_223));
                            item.itemOptions.add(new Item.ItemOption(219, level1_219));
                            item.itemOptions.add(new Item.ItemOption(220, level1_220));
                            item.itemOptions.add(new Item.ItemOption(221, level1_221));
                            item.itemOptions.add(new Item.ItemOption(222, level1_222));
                        }
                        InventoryServiceNew.gI().addItemBag(player, item);
                        Service.getInstance().sendThongBao(player, "Bạn đã Tiến Hóa Ngọc Bội thành công");
                        player.inventory.ruby -= 500000;
                        player.inventory.gold -= 50_000_000_000L;
                        sendEffectSuccessCombine(player);

                        InventoryServiceNew.gI().sendItemBags(player);
                        Service.getInstance().sendMoney(player);
                        player.combineNew.itemsCombine.clear();
                        reOpenItemCombine(player);
                        return;
                    }

                } else {
                    Service.getInstance().sendThongBao(player, "Không đủ điều kiện để Tiến Hóa Ngọc Bội");
                    return;
                }
            }
        }
    }

    private void ThangCapTrangBi(Player player) {
        if (player.combineNew.itemsCombine.size() == 3) {
            Item Trangbi = null;
            Item DaBV = null;
            Item LuaThan = null;
            for (Item item : player.combineNew.itemsCombine) {
                if (item.isNotNullItem()) {
                    if (item.template.type == 0
                            || item.template.type == 1
                            || item.template.type == 2
                            || item.template.type == 3
                            || item.template.type == 4) {
                        Trangbi = item;
                    } else if (item.template.id == 987) {
                        DaBV = item;
                    } else if (item.template.id == 1250) {
                        LuaThan = item;
                    }
                }
            }

            int level_102 = 0;
            int level_216 = 0;
            int level_107 = 0;
            Item.ItemOption optionLevel_102 = null;
            Item.ItemOption optionLevel_216 = null;
            Item.ItemOption optionLevel_107 = null;

            for (Item.ItemOption io : Trangbi.itemOptions) {
                if (io.optionTemplate.id == 102) { // Số Sao Pha Lê
                    level_102 = io.param;
                    optionLevel_102 = io;
                    break;
                }
            }

            for (Item.ItemOption io : Trangbi.itemOptions) {
                if (io.optionTemplate.id == 216) { // Đã Thăng Cấp Mấy Lần
                    level_216 = io.param;
                    optionLevel_216 = io;
                    break;
                }
            }
            for (Item.ItemOption io : Trangbi.itemOptions) {
                if (io.optionTemplate.id == 107) {
                    level_107 = io.param;
                    optionLevel_107 = io;
                    break;
                }
            }

            if (level_102 < 16) {
                Service.getInstance().sendThongBao(player, "Ta Cần Trang Bị Pha Lê Hóa 16 Sao");
                return;
            }
            if (Util.isTrue(100, 100)) {

                if (player.inventory.ruby < 100000) {
                    Service.getInstance().sendThongBao(player, "Điêu Khắc Chỉ Số vào Đá tốn 100K Hồng Ngọc");
                    return;
                } else {

                    if (optionLevel_216 == null && level_102 == 16 && Trangbi != null && DaBV != null && LuaThan != null) {
                        if (DaBV.quantity < 100 || LuaThan.quantity < 100) {
                            Service.getInstance().sendThongBao(player, "Không đủ 100 Đá Bảo Vệ hoặc không đủ 100 Lửa Thần");
                            return;
                        } else {
                            Trangbi.itemOptions.remove(optionLevel_102);
                            Trangbi.itemOptions.remove(optionLevel_107);
                            Trangbi.itemOptions.add(new ItemOption(216, 1));
                            if (Util.isTrue(40, 100)) {
                                Trangbi.itemOptions.add(new ItemOption(194, 1));
                                Trangbi.itemOptions.add(new ItemOption(198, 5));
                            } else if (Util.isTrue(30, 100)) {
                                Trangbi.itemOptions.add(new ItemOption(195, 1));
                                Trangbi.itemOptions.add(new ItemOption(199, 10));
                            } else if (Util.isTrue(20, 100)) {
                                Trangbi.itemOptions.add(new ItemOption(196, 1));
                                Trangbi.itemOptions.add(new ItemOption(200, 15));
                            } else {
                                Trangbi.itemOptions.add(new ItemOption(197, 1));
                                Trangbi.itemOptions.add(new ItemOption(201, 20));
                            }
                            InventoryServiceNew.gI().subQuantityItemsBag(player, DaBV, 100);
                            InventoryServiceNew.gI().subQuantityItemsBag(player, LuaThan, 100);
                        }
                    }
                }
                Service.getInstance().sendThongBao(player, "Bạn Thăng Cấp Trang Bị thành công");
                player.inventory.ruby -= 100000;
                sendEffectSuccessCombine(player);
                InventoryServiceNew.gI().sendItemBags(player);
                Service.getInstance().sendMoney(player);
                player.combineNew.itemsCombine.clear();
                reOpenItemCombine(player);
            }
        }
    }

    private void psHoaTrangBi(Player player) {

        if (player.combineNew.itemsCombine.size() != 2) {
            Service.getInstance().sendThongBao(player, "Thiếu nguyên liệu");
            return;
        }
        if (player.combineNew.itemsCombine.stream().filter(item -> item.isNotNullItem() && item.isTrangBiHacHoa()).count() != 1) {
            Service.getInstance().sendThongBao(player, "Thiếu trang bị pháp sư");
            return;
        }
        if (player.combineNew.itemsCombine.stream().filter(item -> item.isNotNullItem() && item.template.id == 2046).count() != 1) {
            Service.getInstance().sendThongBao(player, "Thiếu đá pháp sư");
            return;
        }
        if (InventoryServiceNew.gI().getCountEmptyBag(player) > 0) {
            if (player.inventory.gold < COST) {
                Service.getInstance().sendThongBao(player, "Con cần thêm vàng để pháp sư hóa...");
                return;
            }
            if (player.inventory.ruby < RUBY) {
                Service.getInstance().sendThongBao(player, "Con cần thêm hồng ngọc để pháp sư hóa...");
                return;
            }
            player.inventory.gold -= COST;
            player.inventory.ruby -= RUBY;
            Item daHacHoa = player.combineNew.itemsCombine.stream().filter(item -> item.template.id == 2046).findFirst().get();
            Item trangBiHacHoa = player.combineNew.itemsCombine.stream().filter(Item::isTrangBiHacHoa).findFirst().get();
            if (daHacHoa == null) {
                Service.getInstance().sendThongBao(player, "Thiếu đá pháp sư");
                return;
            }
            if (trangBiHacHoa == null) {
                Service.getInstance().sendThongBao(player, "Thiếu trang bị pháp sư");
                return;
            }

            if (trangBiHacHoa != null) {
                for (ItemOption itopt : trangBiHacHoa.itemOptions) {
                    if (itopt.optionTemplate.id == 223) {
                        if (itopt.param >= 8) {
                            Service.getInstance().sendThongBao(player, "Trang bị đã đạt tới giới hạn pháp sư");
                            return;
                        }
                    }
                }
            }

            if (Util.isTrue(100, 100)) {
                sendEffectSuccessCombine(player);
                List<Integer> idOptionHacHoa = Arrays.asList(219, 220, 221, 222);
                int randomOption = idOptionHacHoa.get(Util.nextInt(0, 3));
                if (!trangBiHacHoa.haveOption(223)) {
                    trangBiHacHoa.itemOptions.add(new ItemOption(223, 1));
                } else {
                    for (ItemOption itopt : trangBiHacHoa.itemOptions) {
                        if (itopt.optionTemplate.id == 223) {
                            itopt.param += 1;
                            break;
                        }
                    }
                }
                if (!trangBiHacHoa.haveOption(randomOption)) {
                    trangBiHacHoa.itemOptions.add(new ItemOption(randomOption, Util.nextInt(5, 10)));
                } else {
                    for (ItemOption itopt : trangBiHacHoa.itemOptions) {
                        if (itopt.optionTemplate.id == randomOption) {
                            itopt.param += Util.nextInt(5, 10);
                            break;
                        }
                    }
                }

                Service.getInstance().sendThongBao(player, "Bạn đã pháp sư hóa thành công");
            } else {
                sendEffectFailCombine(player);
            }
            InventoryServiceNew.gI().subQuantityItemsBag(player, daHacHoa, 1);
            InventoryServiceNew.gI().sendItemBags(player);
            Service.getInstance().sendMoney(player);
            player.combineNew.itemsCombine.clear();
            reOpenItemCombine(player);
        } else {
            Service.getInstance().sendThongBao(player, "Bạn phải có ít nhất 1 ô trống hành trang");
        }
    }

    private void TinhLuyenTrangBi(Player player) {
        if (player.combineNew.itemsCombine.size() == 5) {
            Item TBTinhAn = null;
            Item ManhTinhAn = null;
            Item LuaThan = null;
            Item VinhDu = null;
            Item DaTinhLuyen = null;

            for (Item item : player.combineNew.itemsCombine) {
                if (item.isNotNullItem()) {
                    if (item.template.id >= 1048 && item.template.id <= 1062) {
                        TBTinhAn = item;
                    } else if (item.template.id == 1232) {
                        ManhTinhAn = item;
                    } else if (item.template.id == 1250) {
                        LuaThan = item;
                    } else if (item.template.id == 1249) {
                        VinhDu = item;
                    } else if (item.template.id == 1265) {
                        DaTinhLuyen = item;
                    }
                }
            }

            int level_34 = 0;
            int level_202 = 0;
            int level_203 = 0;
            int level_205 = 0;

            Item.ItemOption optionLevel_34 = null;
            Item.ItemOption optionLevel_202 = null;
            Item.ItemOption optionLevel_203 = null;
            Item.ItemOption optionLevel_205 = null;

            for (Item.ItemOption io : TBTinhAn.itemOptions) {
                if (io.optionTemplate.id == 34) {
                    level_34 = io.param;
                    optionLevel_34 = io;
                    break;
                }
            }
            for (Item.ItemOption io : TBTinhAn.itemOptions) {
                if (io.optionTemplate.id == 202) {
                    level_202 = io.param;
                    optionLevel_202 = io;
                    break;
                }
            }
            for (Item.ItemOption io : TBTinhAn.itemOptions) {
                if (io.optionTemplate.id == 203) {
                    level_203 = io.param;
                    optionLevel_203 = io;
                    break;
                }
            }

            for (Item.ItemOption io : TBTinhAn.itemOptions) {
                if (io.optionTemplate.id == 205) {
                    level_205 = io.param;
                    optionLevel_205 = io;
                    break;
                }
            }

            if (level_203 >= 10) {
                Service.getInstance().sendThongBao(player, "Trang Bị Đã Tinh Luyện Tối Đa");
                return;
            }

            if (TBTinhAn == null || ManhTinhAn == null || LuaThan == null || VinhDu == null || DaTinhLuyen == null) {
                Service.getInstance().sendThongBao(player, "Không đủ vật phẩm để Tinh Luyện Trang Bị");
                return;
            }

            if (player.inventory.gold < COST_TINH_LUYEN || player.inventory.ruby < RUBY_TINH_LUYEN || player.inventory.gem < GEM_TINH_LUYEN) {
                Service.getInstance().sendThongBao(player, "Không đủ tiền để Tinh Luyện");
                return;
            }

            if (Util.isTrue(100, 100)) {
                if (TBTinhAn != null && optionLevel_34 != null) {
                    if (ManhTinhAn.quantity >= 10 && LuaThan.quantity >= 100 && VinhDu.quantity >= 20 && DaTinhLuyen.quantity >= 1) {
//                                        sendEffectFailCombine(player);

                        if (optionLevel_202 == null) {
                            TBTinhAn.itemOptions.add(new Item.ItemOption(202, 1));
                        } else {
                            optionLevel_202.param += Util.nextInt(1, 3);
                            if (optionLevel_202.param >= 100) {
                                if (optionLevel_203 == null) {
                                    TBTinhAn.itemOptions.add(new Item.ItemOption(203, 1));
                                    TBTinhAn.itemOptions.add(new Item.ItemOption(205, 5));
                                } else {
                                    optionLevel_203.param++;
                                    optionLevel_205.param += 5;
                                }
                                optionLevel_202.param -= 100;
                            }
                        }
                        InventoryServiceNew.gI().subQuantityItemsBag(player, ManhTinhAn, 10);
                        InventoryServiceNew.gI().subQuantityItemsBag(player, LuaThan, 100);
                        InventoryServiceNew.gI().subQuantityItemsBag(player, VinhDu, 10);
                        InventoryServiceNew.gI().subQuantityItemsBag(player, DaTinhLuyen, 1);
                        Service.getInstance().sendThongBao(player, "Bạn đã Tinh Luyện Thành Công");

                        player.inventory.ruby -= RUBY_TINH_LUYEN;
                        player.inventory.gold -= COST_TINH_LUYEN;
                        player.inventory.gem -= GEM_TINH_LUYEN;

                        InventoryServiceNew.gI().sendItemBags(player);
                        Service.getInstance().sendMoney(player);
                        reOpenItemCombine(player);
                        return;
                    }
                }
            }
        } else {
            Service.getInstance().sendThongBao(player, "Thiếu Nguyên Liệu");
            return;
        }
    }

    private void LuyenBiTich(Player player) {
        if (player.combineNew.itemsCombine.size() == 2) {
            Item BiTich = null;
            Item SachLuyen = null;

            for (Item item : player.combineNew.itemsCombine) {
                if (item.isNotNullItem()) {
                    if (item.template.id == 1393) {
                        BiTich = item;
                    } else if (item.template.id == 1392) {
                        SachLuyen = item;
                    }
                }
            }

            int level_224 = 0;
            int level_225 = 0;
            int level_226 = 0;

            Item.ItemOption optionLevel_224 = null;
            Item.ItemOption optionLevel_225 = null;
            Item.ItemOption optionLevel_226 = null;

            for (Item.ItemOption io : BiTich.itemOptions) {
                if (io.optionTemplate.id == 224) {
                    level_224 = io.param;
                    optionLevel_224 = io;
                    break;
                }
            }
            for (Item.ItemOption io : BiTich.itemOptions) {
                if (io.optionTemplate.id == 225) {
                    level_225 = io.param;
                    optionLevel_225 = io;
                    break;
                }
            }
            for (Item.ItemOption io : BiTich.itemOptions) {
                if (io.optionTemplate.id == 226) {
                    level_226 = io.param;
                    optionLevel_226 = io;
                    break;
                }
            }

            if (level_224 <= 0) {
                Service.getInstance().sendThongBao(player, "Bí Tịch hết lượt luyện");
                return;
            }

            if (BiTich == null || SachLuyen == null) {
                Service.getInstance().sendThongBao(player, "Không đủ vật phẩm để Luyện Bí Tịch");
                return;
            }

            if (player.inventory.gold < 100_000_000 || player.inventory.ruby < 1000 || player.inventory.gem < 1000) {
                Service.getInstance().sendThongBao(player, "Không đủ tiền để Luyện Bí Tịch");
                return;
            }

            if (Util.isTrue(100, 100)) {
                if (BiTich != null && level_224 > 0) {
                    if (SachLuyen.quantity >= 1) {
                        optionLevel_225.param += Util.nextInt(30, 50);
                        if (optionLevel_225.param >= 1000) {
                            optionLevel_226.param++;
                            optionLevel_224.param--;
                            optionLevel_225.param -= 1000;

                            if (BiTich.haveOption(50)) {
                                for (ItemOption itopt : BiTich.itemOptions) {
                                    if (itopt.optionTemplate.id == 50) {
                                        itopt.param += Util.nextInt(1, 2);
                                        break;
                                    }
                                }
                            }
                            if (BiTich.haveOption(77)) {
                                for (ItemOption itopt : BiTich.itemOptions) {
                                    if (itopt.optionTemplate.id == 77) {
                                        itopt.param += Util.nextInt(1, 2);
                                        break;
                                    }
                                }
                            }
                            if (BiTich.haveOption(103)) {
                                for (ItemOption itopt : BiTich.itemOptions) {
                                    if (itopt.optionTemplate.id == 103) {
                                        itopt.param += Util.nextInt(1, 2);
                                        break;
                                    }
                                }
                            }
                            if (BiTich.haveOption(5)) {
                                for (ItemOption itopt : BiTich.itemOptions) {
                                    if (itopt.optionTemplate.id == 5) {
                                        itopt.param += Util.nextInt(1, 2);
                                        break;
                                    }
                                }
                            }
                            if (BiTich.haveOption(101)) {
                                for (ItemOption itopt : BiTich.itemOptions) {
                                    if (itopt.optionTemplate.id == 101) {
                                        itopt.param += Util.nextInt(1, 2);
                                        break;
                                    }
                                }
                            }
                            if (optionLevel_224.param == 0) {
                                BiTich.itemOptions.remove(optionLevel_225);
                            }
                        }
                        InventoryServiceNew.gI().subQuantityItemsBag(player, SachLuyen, 1);
                        Service.getInstance().sendThongBao(player, "Bạn đã Luyện Bí Tịch Thành Công");

                        player.inventory.ruby -= 1000;
                        player.inventory.gold -= 100_000_000;
                        player.inventory.gem -= 1000;

                        InventoryServiceNew.gI().sendItemBags(player);
                        Service.getInstance().sendMoney(player);
                        reOpenItemCombine(player);
                        return;
                    }
                }
            }
        } else {
            Service.getInstance().sendThongBao(player, "Thiếu Nguyên Liệu");
            return;
        }
    }

    private void tayHacHoaTrangBi(Player player) {

        if (player.combineNew.itemsCombine.size() != 2) {
            Service.getInstance().sendThongBao(player, "Thiếu nguyên liệu");
            return;
        }
        if (player.combineNew.itemsCombine.stream().filter(item -> item.isNotNullItem() && item.isTrangBiHacHoa()).count() != 1) {
            Service.getInstance().sendThongBao(player, "Thiếu trang bị hắc hóa");
            return;
        }
        if (player.combineNew.itemsCombine.stream().filter(item -> item.isNotNullItem() && item.template.id == 2047).count() != 1) {
            Service.getInstance().sendThongBao(player, "Thiếu đá pháp sư");
            return;
        }
        if (InventoryServiceNew.gI().getCountEmptyBag(player) > 0) {
            if (player.inventory.gold < 0) {
                Service.getInstance().sendThongBao(player, "Con cần thêm vàng để đổi...");
                return;
            }
            player.inventory.gold -= 0;
            Item buagiaihachoa = player.combineNew.itemsCombine.stream().filter(item -> item.template.id == 2047).findFirst().get();
            Item trangBiHacHoa = player.combineNew.itemsCombine.stream().filter(Item::isTrangBiHacHoa).findFirst().get();
            if (buagiaihachoa == null) {
                Service.getInstance().sendThongBao(player, "Thiếu bùa giải pháp sư");
                return;
            }
            if (trangBiHacHoa == null) {
                Service.getInstance().sendThongBao(player, "Thiếu trang bị pháp sư");
                return;
            }

            if (Util.isTrue(100, 100)) {
                sendEffectSuccessCombine(player);
                List<Integer> idOptionHacHoa = Arrays.asList(219, 220, 221, 222);

                ItemOption option_223 = new ItemOption();
                ItemOption option_219 = new ItemOption();
                ItemOption option_220 = new ItemOption();
                ItemOption option_221 = new ItemOption();
                ItemOption option_222 = new ItemOption();

                for (ItemOption itopt : trangBiHacHoa.itemOptions) {
                    if (itopt.optionTemplate.id == 223) {
                        System.out.println("223");
                        option_223 = itopt;
                    }
                    if (itopt.optionTemplate.id == 219) {
                        System.out.println("219");
                        option_219 = itopt;
                    }
                    if (itopt.optionTemplate.id == 220) {
                        System.out.println("220");
                        option_220 = itopt;
                    }
                    if (itopt.optionTemplate.id == 221) {
                        System.out.println("221");
                        option_221 = itopt;
                    }
                    if (itopt.optionTemplate.id == 222) {
                        System.out.println("222");
                        option_222 = itopt;
                    }
                }
                if (option_223 != null) {
                    trangBiHacHoa.itemOptions.remove(option_223);
                }
                if (option_219 != null) {
                    trangBiHacHoa.itemOptions.remove(option_219);
                }
                if (option_220 != null) {
                    trangBiHacHoa.itemOptions.remove(option_220);
                }
                if (option_221 != null) {
                    trangBiHacHoa.itemOptions.remove(option_221);
                }
                if (option_222 != null) {
                    trangBiHacHoa.itemOptions.remove(option_222);
                }
                Service.getInstance().sendThongBao(player, "Bạn đã tẩy thành công");
                InventoryServiceNew.gI().sendItemBags(player);
            } else {
                sendEffectFailCombine(player);
            }
            InventoryServiceNew.gI().subQuantityItemsBag(player, buagiaihachoa, 1);
            InventoryServiceNew.gI().sendItemBags(player);
            Service.getInstance().sendMoney(player);
            player.combineNew.itemsCombine.clear();
            reOpenItemCombine(player);
        }
    }

    public void GetTrangBiKichHoathuydiet(Player player, int id) {
        Item item = ItemService.gI().createNewItem((short) id);
        int[][] optionNormal = {{127, 128}, {130, 132}, {133, 135}};
        int[][] paramNormal = {{139, 140}, {142, 144}, {136, 138}};
        int[][] optionVIP = {{129}, {131}, {134}};
        int[][] paramVIP = {{141}, {143}, {137}};
        int random = Util.nextInt(optionNormal.length);
        int randomSkh = Util.nextInt(100);
        if (item.template.type == 0) {
            item.itemOptions.add(new ItemOption(47, Util.nextInt(800, 1120)));
        }
        if (item.template.type == 1) {
            item.itemOptions.add(new ItemOption(22, Util.nextInt(80, 104)));
        }
        if (item.template.type == 2) {
            item.itemOptions.add(new ItemOption(0, Util.nextInt(8800, 12000)));
        }
        if (item.template.type == 3) {
            item.itemOptions.add(new ItemOption(23, Util.nextInt(80, 120)));
        }
        if (item.template.type == 4) {
            item.itemOptions.add(new ItemOption(14, Util.nextInt(17, 21)));
        }

        InventoryServiceNew.gI().addItemBag(player, item);
        InventoryServiceNew.gI().sendItemBags(player);
    }

    public void thuctinhDT(Player player, int menu) {
        if (player.combineNew.itemsCombine.size() == 3) {
            Item dathuctinh = null;
            Item ngocrong = null;
            Item ngocrongsp = null;
            Item tv = null;
            for (Item item : player.combineNew.itemsCombine) {
                if (item.template.id == 16) {
                    ngocrong = item;
                } else if (item.template.id == 14) {
                    ngocrongsp = item;
                } else if (item.template.id == 1421) {
                    dathuctinh = item;
                } else if (item.template.id == 457) {
                    tv = item;
                }
            }
            if (ngocrongsp != null && ngocrongsp.quantity >= (3) && dathuctinh != null && dathuctinh.quantity >= (30) && tv != null && tv.quantity >= (3)) {
                try {
                    int count = 0;
                    while (menu > 0) {
                        menu--;
                        count++;
                        if (player.nPoint.getHpMpLimit() >= 680000 && player.nPoint.dameg >= 38000) {
                            this.lmht.createOtherMenu(player, ConstNpc.IGNORE_MENU,
                                    "Bạn đã đạt cấp độ thức tỉnh tối đa tối đa", "Đóng");
                            break;
                        }
                        String npcSay = "|7|[ THỨC TỈNH BẢN THÂN ]"
                                + "\n|5|HP: " + player.nPoint.hpg
                                + "\nKI: " + player.nPoint.mpg
                                + "\nSD: " + player.nPoint.dameg
                                + "\n|7|Tỉ lệ thành công: "
                                + (player.nPoint.getHpMpLimit() >= 600000 && player.nPoint.getHpMpLimit() < 620000
                                && player.nPoint.dameg >= 32000 && player.nPoint.dameg < 34000 ? "50%"
                                        : player.nPoint.getHpMpLimit() >= 620000 && player.nPoint.getHpMpLimit() < 640000
                                        && player.nPoint.dameg >= 34000 && player.nPoint.dameg < 36000 ? "30%" : "10%")
                                + "\nCount Đã Nâng: " + count + "\n|-1|Đá thức tỉnh: " + dathuctinh.quantity
                                + "\nThỏi vàng: " + tv.quantity + "\nNgọc rồng: " + ngocrongsp.quantity + "\n";
                        this.lmht.createOtherMenu(player, ConstNpc.MENU_START_COMBINE, npcSay,
                                "Nâng X1\nCần 100\nHồng Ngọc", "Nâng X10\nCần 1.000\nHồng Ngọc", "Nâng X100\nCần 10.000\nHồng Ngọc");
                        if (Util.isTrue((player.nPoint.hpg >= 600000 && player.nPoint.hpg < 620000
                                && player.nPoint.mpg >= 600000 && player.nPoint.mpg < 620000
                                && player.nPoint.dameg >= 32000 && player.nPoint.dameg < 34000 ? 50
                                        : player.nPoint.hpg >= 620000 && player.nPoint.hpg < 640000
                                        && player.nPoint.mpg >= 620000 && player.nPoint.mpg < 640000
                                        && player.nPoint.dameg >= 34000 && player.nPoint.dameg < 36000 ? 30 : 5), 100)) {
                            int[][] randomcs = {{Util.nextInt(100, 500)}, {Util.nextInt(500, 1000)}};
                            InventoryServiceNew.gI().subQuantityItemsBag(player, ngocrongsp, (3));
                            InventoryServiceNew.gI().subQuantityItemsBag(player, dathuctinh, (30));
                            InventoryServiceNew.gI().subQuantityItemsBag(player, tv, (3));
                            player.inventory.ruby -= (100);
                            sendEffectSuccessCombine(player);
                            player.nPoint.hpg += Util.nextInt(randomcs[0][0], randomcs[1][0]);
                            player.nPoint.mpg += Util.nextInt(randomcs[0][0], randomcs[1][0]);
                            player.nPoint.dameg += Util.nextInt(randomcs[0][0], randomcs[1][0]);
                            if (player.nPoint.hpg > 680000) {
                                player.nPoint.hpg = 680000;
                            }
                            if (player.nPoint.mpg > 680000) {
                                player.nPoint.mpg = 680000;
                            }
                            if (player.nPoint.dameg > 38000) {
                                player.nPoint.dameg = 38000;
                            }
                            npcSay += "|7|Đột phá thành công, chỉ số đã tăng thêm 1 bậc!\nTiếp tục sau 3s";
                            this.lmht.createOtherMenu(player, ConstNpc.MENU_START_COMBINE, npcSay,
                                    "Nâng X1\nCần 100\nHồng Ngọc", "Nâng X10\nCần 1.000\nHồng Ngọc", "Nâng X100\nCần 10.000\nHồng Ngọc");
                            Thread.sleep(2500);
                        } else {
                            InventoryServiceNew.gI().subQuantityItemsBag(player, dathuctinh, (30));
                            sendEffectFailCombine(player);
                        }
                        InventoryServiceNew.gI().sendItemBags(player);
                        Service.gI().sendMoney(player);
                        reOpenItemCombine(player);
                    }
                } catch (Exception e) {
                }
            } else if (ngocrong != null && ngocrong.quantity >= (3) && dathuctinh != null && dathuctinh.quantity >= (15) && tv != null && tv.quantity >= (1)) {
                try {
                    int count = 0;
                    while (menu > 0) {
                        menu--;
                        count++;
                        String tsSay = "|7|[ THỨC TỈNH ĐỆ TỬ ]\n" + player.pet.name.substring(1)
                                + "\n|5|Cấp bậc : " + player.pet.getNameThuctinh(player.pet.thuctinh)
                                + "\nHP: " + (player.pet.nPoint.hpg >= 680000 ? Util.format(player.pet.nPoint.hpg)
                                        : Util.format(player.pet.nPoint.hpg) + " Cấp Sau: " + Util.format(player.pet.nPoint.hpg + 200))
                                + "\nKI: " + (player.pet.nPoint.mpg >= 680000 ? Util.format(player.pet.nPoint.mpg)
                                        : Util.format(player.pet.nPoint.mpg) + " Cấp Sau: " + Util.format(player.pet.nPoint.mpg + 200))
                                + "\nSD: " + (player.pet.nPoint.dameg >= 38000 ? Util.format(player.pet.nPoint.dameg)
                                        : Util.format(player.pet.nPoint.dameg) + " Cấp Sau: " + Util.format(player.pet.nPoint.dameg + 100))
                                + "\n|7|Tỉ lệ thành công: "
                                + (player.pet.nPoint.hpg >= 600000 && player.pet.nPoint.hpg < 620000
                                && player.pet.nPoint.mpg >= 600000 && player.pet.nPoint.mpg < 620000
                                && player.pet.nPoint.dameg >= 32000 && player.pet.nPoint.dameg < 34000 ? "50%"
                                        : player.pet.nPoint.hpg >= 620000 && player.pet.nPoint.hpg < 640000
                                        && player.pet.nPoint.mpg >= 620000 && player.pet.nPoint.mpg < 640000
                                        && player.pet.nPoint.dameg >= 34000 && player.pet.nPoint.dameg < 36000 ? "30%" : "10%")
                                + "\nCount Đã Nâng: " + count + "\n|-1|Đá thức tỉnh: " + dathuctinh.quantity
                                + "\nThỏi vàng: " + tv.quantity + "\nNgọc rồng: " + ngocrong.quantity + "\n";
                        this.lmht.createOtherMenu(player, ConstNpc.MENU_START_COMBINE, tsSay,
                                "Nâng X1\nCần 100\nHồng Ngọc", "Nâng X10\nCần 1.000\nHồng Ngọc", "Nâng X100\nCần 10.000\nHồng Ngọc");
                        if (Util.isTrue((player.pet.nPoint.hpg >= 600000 && player.pet.nPoint.hpg < 620000
                                && player.pet.nPoint.mpg >= 600000 && player.pet.nPoint.mpg < 620000
                                && player.pet.nPoint.dameg >= 32000 && player.pet.nPoint.dameg < 34000 ? 50
                                        : player.pet.nPoint.hpg >= 620000 && player.pet.nPoint.hpg < 640000
                                        && player.pet.nPoint.mpg >= 620000 && player.pet.nPoint.mpg < 640000
                                        && player.pet.nPoint.dameg >= 34000 && player.pet.nPoint.dameg < 36000 ? 30 : 10), 100)) {
                            InventoryServiceNew.gI().subQuantityItemsBag(player, ngocrong, 3);
                            InventoryServiceNew.gI().subQuantityItemsBag(player, dathuctinh, 15);
                            InventoryServiceNew.gI().subQuantityItemsBag(player, tv, 1);
                            player.inventory.ruby -= 100;
                            if (Util.isTrue(50, 100)) {
                                player.pet.nPoint.hpg += 200;
                                player.pet.nPoint.mpg += 200;
                                player.pet.nPoint.dameg += 100;
                            } else {
                                player.pet.nPoint.tiemNangUp(Util.nextInt(10000, 100000));
                            }
                            if (player.pet != null && player.pet.thuctinh < 30) {
                                if (player.pet.thuctinh >= 0 && player.pet.thuctinh < 10 && Util.isTrue(30, 100)) {
                                    player.pet.thuctinh++;
                                    tsSay += "\n|7|Đột phá thành công, cấp thức tỉnh tăng 1 bậc\nTiếp tục sau 3s\n";
                                    this.lmht.createOtherMenu(player, ConstNpc.MENU_START_COMBINE, tsSay,
                                            "Nâng X1\nCần 100\nHồng Ngọc", "Nâng X10\nCần 1.000\nHồng Ngọc", "Nâng X100\nCần 10.000\nHồng Ngọc");
                                    Thread.sleep(2500);
                                } else if (player.pet.thuctinh >= 10 && player.pet.thuctinh < 20 && Util.isTrue(20, 100)) {
                                    player.pet.thuctinh++;
                                    tsSay += "\n|7|Đột phá thành công, cấp thức tỉnh tăng 1 bậc\nTiếp tục sau 3s\n";
                                    this.lmht.createOtherMenu(player, ConstNpc.MENU_START_COMBINE, tsSay,
                                            "Nâng X1\nCần 100\nHồng Ngọc", "Nâng X10\nCần 1.000\nHồng Ngọc", "Nâng X100\nCần 10.000\nHồng Ngọc");
                                    Thread.sleep(2500);
                                } else if (player.pet.thuctinh >= 20 && player.pet.thuctinh < 30 && Util.isTrue(10, 100)) {
                                    player.pet.thuctinh++;
                                    tsSay += "\n|7|Đột phá thành công, cấp thức tỉnh tăng 1 bậc\nTiếp tục sau 3s\n";
                                    this.lmht.createOtherMenu(player, ConstNpc.MENU_START_COMBINE, tsSay,
                                            "Nâng X1\nCần 100\nHồng Ngọc", "Nâng X10\nCần 1.000\nHồng Ngọc", "Nâng X100\nCần 10.000\nHồng Ngọc");
                                    Thread.sleep(2500);
                                }
                            }
                            if (player.pet.typePet == 0 && player.pet.thuctinh == 10) {
                                player.pet.typePet++;
                                player.pet.name = "$" + "Mabu";
                                ChangeMapService.gI().exitMap(player.pet);
                                tsSay += "\n|7|May mắn!\nĐệ tử đã tiến hoá thành Mabu!\n";
                                this.lmht.createOtherMenu(player, ConstNpc.MENU_START_COMBINE, tsSay,
                                        "Nâng X1\nCần 100\nHồng Ngọc", "Nâng X10\nCần 1.000\nHồng Ngọc", "Nâng X100\nCần 10.000\nHồng Ngọc");
                                Thread.sleep(2500);
                            } else if (player.pet.typePet == 1 && player.pet.thuctinh == 20) {
                                player.pet.typePet++;
                                player.pet.name = "$" + "Gohan Buu";
                                ChangeMapService.gI().exitMap(player.pet);
                                tsSay += "\n|7|May mắn!\nĐệ tử đã tiến hoá thành Buu Han!\n";
                                this.lmht.createOtherMenu(player, ConstNpc.MENU_START_COMBINE, tsSay,
                                        "Nâng X1\nCần 100\nHồng Ngọc", "Nâng X10\nCần 1.000\nHồng Ngọc", "Nâng X100\nCần 10.000\nHồng Ngọc");
                                Thread.sleep(2500);
                            } else if (player.pet.typePet == 2 && player.pet.thuctinh == 30) {
                                player.pet.typePet++;
                                player.pet.name = "$" + "Evil Buu";
                                ChangeMapService.gI().exitMap(player.pet);
                                tsSay += "\n|7|May mắn!\nĐệ tử đã tiến hoá thành Evio Buu!\n";
                                this.lmht.createOtherMenu(player, ConstNpc.MENU_START_COMBINE, tsSay,
                                        "Nâng X1\nCần 100\nHồng Ngọc", "Nâng X10\nCần 1.000\nHồng Ngọc", "Nâng X100\nCần 10.000\nHồng Ngọc");
                                Thread.sleep(2500);
                            }
                            if (player.pet.nPoint.hpg > 680000) {
                                player.pet.nPoint.hpg = 680000;
                            }
                            if (player.pet.nPoint.mpg > 680000) {
                                player.pet.nPoint.mpg = 680000;
                            }
                            if (player.pet.nPoint.dameg > 36000) {
                                player.pet.nPoint.dameg = 36000;
                            }
                        } else {
                            InventoryServiceNew.gI().subQuantityItemsBag(player, dathuctinh, 15);
                            sendEffectFailCombine(player);
                        }
                        InventoryServiceNew.gI().sendItemBags(player);
                        Service.gI().sendMoney(player);
                        reOpenItemCombine(player);
                    }
                } catch (Exception e) {
                }
            } else {
                Service.gI().sendThongBao(player, "Không đủ nguyên liệu để thực hiện");
            }
        } else {
            Service.gI().sendThongBao(player, "Không đủ nguyên liệu để thực hiện");
        }
    }

    public void GetTrangBiKichHoatthiensu(Player player, int id) {
        Item item = ItemService.gI().createNewItem((short) id);
        int[][] optionNormal = {{127, 128}, {130, 132}, {133, 135}};
        int[][] paramNormal = {{139, 140}, {142, 144}, {136, 138}};
        int[][] optionVIP = {{129}, {131}, {134}};
        int[][] paramVIP = {{141}, {143}, {137}};
        int random = Util.nextInt(optionNormal.length);
        int randomSkh = Util.nextInt(100);
        if (item.template.type == 0) {
            item.itemOptions.add(new ItemOption(47, Util.nextInt(2000, 2500)));
        }
        if (item.template.type == 1) {
            item.itemOptions.add(new ItemOption(22, Util.nextInt(150, 200)));
        }
        if (item.template.type == 2) {
            item.itemOptions.add(new ItemOption(0, Util.nextInt(18000, 20000)));
        }
        if (item.template.type == 3) {
            item.itemOptions.add(new ItemOption(23, Util.nextInt(150, 200)));
        }
        if (item.template.type == 4) {
            item.itemOptions.add(new ItemOption(14, Util.nextInt(20, 25)));
        }
        if (randomSkh <= 20) {//tile ra do kich hoat
            if (randomSkh <= 5) { // tile ra option vip
                item.itemOptions.add(new ItemOption(optionVIP[player.gender][0], 0));
                item.itemOptions.add(new ItemOption(paramVIP[player.gender][0], 0));
                item.itemOptions.add(new ItemOption(30, 0));
            } else {// 
                item.itemOptions.add(new ItemOption(optionNormal[player.gender][random], 0));
                item.itemOptions.add(new ItemOption(paramNormal[player.gender][random], 0));
                item.itemOptions.add(new ItemOption(30, 0));
            }
        }

        InventoryServiceNew.gI().addItemBag(player, item);
        InventoryServiceNew.gI().sendItemBags(player);
    }

    private void doiKiemThan(Player player) {
        if (player.combineNew.itemsCombine.size() == 3) {
            Item keo = null, luoiKiem = null, chuoiKiem = null;
            for (Item it : player.combineNew.itemsCombine) {
                if (it.template.id == 2015) {
                    keo = it;
                } else if (it.template.id == 2016) {
                    chuoiKiem = it;
                } else if (it.template.id == 2017) {
                    luoiKiem = it;
                }
            }
            if (keo != null && keo.quantity >= 99 && luoiKiem != null && chuoiKiem != null) {
                if (InventoryServiceNew.gI().getCountEmptyBag(player) > 0) {
                    sendEffectSuccessCombine(player);
                    Item item = ItemService.gI().createNewItem((short) 2018);
                    item.itemOptions.add(new Item.ItemOption(50, Util.nextInt(9, 15)));
                    item.itemOptions.add(new Item.ItemOption(77, Util.nextInt(8, 15)));
                    item.itemOptions.add(new Item.ItemOption(103, Util.nextInt(8, 15)));
                    if (Util.isTrue(80, 100)) {
                        item.itemOptions.add(new Item.ItemOption(93, Util.nextInt(1, 15)));
                    }
                    InventoryServiceNew.gI().addItemBag(player, item);

                    InventoryServiceNew.gI().subQuantityItemsBag(player, keo, 99);
                    InventoryServiceNew.gI().subQuantityItemsBag(player, luoiKiem, 1);
                    InventoryServiceNew.gI().subQuantityItemsBag(player, chuoiKiem, 1);

                    InventoryServiceNew.gI().sendItemBags(player);
                    Service.getInstance().sendMoney(player);
                    reOpenItemCombine(player);
                }
            }
        }
    }

    private void doiChuoiKiem(Player player) {
        if (player.combineNew.itemsCombine.size() == 1) {
            Item manhNhua = player.combineNew.itemsCombine.get(0);
            if (manhNhua.template.id == 2014 && manhNhua.quantity >= 99) {
                if (InventoryServiceNew.gI().getCountEmptyBag(player) > 0) {
                    sendEffectSuccessCombine(player);
                    Item item = ItemService.gI().createNewItem((short) 2016);
                    InventoryServiceNew.gI().addItemBag(player, item);

                    InventoryServiceNew.gI().subQuantityItemsBag(player, manhNhua, 99);

                    InventoryServiceNew.gI().sendItemBags(player);
                    Service.getInstance().sendMoney(player);
                    reOpenItemCombine(player);
                }
            }
        }
    }

    private void doiLuoiKiem(Player player) {
        if (player.combineNew.itemsCombine.size() == 1) {
            Item manhSat = player.combineNew.itemsCombine.get(0);
            if (manhSat.template.id == 2013 && manhSat.quantity >= 99) {
                if (InventoryServiceNew.gI().getCountEmptyBag(player) > 0) {
                    sendEffectSuccessCombine(player);
                    Item item = ItemService.gI().createNewItem((short) 2017);
                    InventoryServiceNew.gI().addItemBag(player, item);
                    InventoryServiceNew.gI().subQuantityItemsBag(player, manhSat, 99);

                    InventoryServiceNew.gI().sendItemBags(player);
                    Service.getInstance().sendMoney(player);
                    reOpenItemCombine(player);
                }
            }
        }
    }

    private void doiManhKichHoat(Player player) {
        if (player.combineNew.itemsCombine.size() == 2 || player.combineNew.itemsCombine.size() == 3) {
            Item nr1s = null, doThan = null, buaBaoVe = null;
            for (Item it : player.combineNew.itemsCombine) {
                if (it.template.id == 14) {
                    nr1s = it;
                } else if (it.template.id == 2010) {
                    buaBaoVe = it;
                } else if (it.template.id >= 555 && it.template.id <= 567) {
                    doThan = it;
                }
            }

            if (nr1s != null && doThan != null) {
                if (InventoryServiceNew.gI().getCountEmptyBag(player) > 0
                        && player.inventory.gold >= COST_DOI_MANH_KICH_HOAT) {
                    player.inventory.gold -= COST_DOI_MANH_KICH_HOAT;
                    int tiLe = buaBaoVe != null ? 100 : 50;
                    if (Util.isTrue(tiLe, 100)) {
                        sendEffectSuccessCombine(player);
                        Item item = ItemService.gI().createNewItem((short) 2009);
                        item.itemOptions.add(new Item.ItemOption(30, 0));
                        InventoryServiceNew.gI().addItemBag(player, item);
                    } else {
                        sendEffectFailCombine(player);
                    }
                    InventoryServiceNew.gI().subQuantityItemsBag(player, nr1s, 1);
                    InventoryServiceNew.gI().subQuantityItemsBag(player, doThan, 1);
                    if (buaBaoVe != null) {
                        InventoryServiceNew.gI().subQuantityItemsBag(player, buaBaoVe, 1);
                    }
                    InventoryServiceNew.gI().sendItemBags(player);
                    Service.getInstance().sendMoney(player);
                    reOpenItemCombine(player);
                }
            } else {
                this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Hãy chọn 1 trang bị thần linh và 1 viên ngọc rồng 1 sao", "Đóng");
            }
        }
    }

    private void phanradothanlinh(Player player) {
        if (player.combineNew.itemsCombine.size() == 1) {
            player.inventory.gold -= 50000000;
            List<Integer> itemdov2 = new ArrayList<>(Arrays.asList(562, 564, 566));
            Item item = player.combineNew.itemsCombine.get(0);
            int couponAdd = itemdov2.stream().anyMatch(t -> t == item.template.id) ? 2 : item.template.id == 561 ? 3 : 1;
            sendEffectSuccessCombine(player);
            Item dangusac = ItemService.gI().createNewItem((short) 674);
            Item dangusac1 = ItemService.gI().createNewItem((short) 674);
            Item dangusac2 = ItemService.gI().createNewItem((short) 674);
            InventoryServiceNew.gI().addItemBag(player, dangusac);
            InventoryServiceNew.gI().sendItemBags(player);
            if (item.template.id == 561) {
                InventoryServiceNew.gI().addItemBag(player, dangusac);
                InventoryServiceNew.gI().addItemBag(player, dangusac1);
                InventoryServiceNew.gI().addItemBag(player, dangusac2);
                InventoryServiceNew.gI().sendItemBags(player);
            } else if (item.template.id == 562 || item.template.id == 564 || item.template.id == 566) {
                InventoryServiceNew.gI().addItemBag(player, dangusac);
                InventoryServiceNew.gI().addItemBag(player, dangusac1);
                InventoryServiceNew.gI().sendItemBags(player);
            }
            Service.gI().sendThongBaoOK(player, "Bạn Nhận Được Đá Ngũ Sắc");
            InventoryServiceNew.gI().subQuantityItemsBag(player, item, 1);
            player.combineNew.itemsCombine.clear();
            InventoryServiceNew.gI().sendItemBags(player);
            Service.gI().sendMoney(player);
            reOpenItemCombine(player);
        }
    }

    public void openDTS(Player player) {
        //check sl đồ tl, đồ hd
        // new update 2 mon huy diet + 1 mon than linh(skh theo style) +  5 manh bat ki
        if (player.combineNew.itemsCombine.size() != 4) {
            Service.getInstance().sendThongBao(player, "Thiếu đồ");
            return;
        }
        if (player.inventory.gold < COST) {
            Service.getInstance().sendThongBao(player, "Con không đủ vàng");
            return;
        }
        if (InventoryServiceNew.gI().getCountEmptyBag(player) < 1) {
            Service.getInstance().sendThongBao(player, "Bạn phải có ít nhất 1 ô trống hành trang");
            return;
        }
        Item itemTL = player.combineNew.itemsCombine.stream().filter(item -> item.isNotNullItem() && item.isDTL()).findFirst().get();
        List<Item> itemHDs = player.combineNew.itemsCombine.stream().filter(item -> item.isNotNullItem() && item.isDHD()).collect(Collectors.toList());
        Item itemManh = player.combineNew.itemsCombine.stream().filter(item -> item.isNotNullItem() && item.isManhTS() && item.quantity >= 999).findFirst().get();

        player.inventory.gold -= COST;
        sendEffectSuccessCombine(player);
        short[][] itemIds = {{1048, 1051, 1054, 1057, 1060}, {1049, 1052, 1055, 1058, 1061}, {1050, 1053, 1056, 1059, 1062}}; // thứ tự td - 0,nm - 1, xd - 2

        Item itemTS = ItemService.gI().DoThienSu(itemIds[itemTL.template.gender > 2 ? player.gender : itemTL.template.gender][itemManh.typeIdManh()], itemTL.template.gender);
        InventoryServiceNew.gI().addItemBag(player, itemTS);

        InventoryServiceNew.gI().subQuantityItemsBag(player, itemTL, 1);
        InventoryServiceNew.gI().subQuantityItemsBag(player, itemManh, 999);
        itemHDs.forEach(item -> InventoryServiceNew.gI().subQuantityItemsBag(player, item, 1));
        InventoryServiceNew.gI().sendItemBags(player);
        Service.getInstance().sendMoney(player);
        Service.getInstance().sendThongBao(player, "Bạn đã nhận được " + itemTS.template.name);
        player.combineNew.itemsCombine.clear();
        reOpenItemCombine(player);
    }

    public void openSKHVIP(Player player) {
        // 1 thiên sứ + 2 món kích hoạt -- món đầu kh làm gốc
        if (player.combineNew.itemsCombine.size() != 3) {
            Service.getInstance().sendThongBao(player, "Thiếu nguyên liệu");
            return;
        }
        if (player.combineNew.itemsCombine.stream().filter(item -> item.isNotNullItem() && item.isDTS()).count() != 1) {
            Service.getInstance().sendThongBao(player, "Thiếu đồ thiên sứ");
            return;
        }
        if (player.combineNew.itemsCombine.stream().filter(item -> item.isNotNullItem() && item.isSKH()).count() != 2) {
            Service.getInstance().sendThongBao(player, "Thiếu đồ kích hoạt");
            return;
        }
        if (InventoryServiceNew.gI().getCountEmptyBag(player) > 0) {
            if (player.inventory.gold < 1) {
                Service.getInstance().sendThongBao(player, "Con cần thêm vàng để đổi...");
                return;
            }
            player.inventory.gold -= COST;
            Item itemTS = player.combineNew.itemsCombine.stream().filter(Item::isDTS).findFirst().get();
            List<Item> itemSKH = player.combineNew.itemsCombine.stream().filter(item -> item.isNotNullItem() && item.isSKH()).collect(Collectors.toList());
            CombineServiceNew.gI().sendEffectOpenItem(player, itemTS.template.iconID, itemTS.template.iconID);
            short itemId;
            if (itemTS.template.gender == 3 || itemTS.template.type == 4) {
                itemId = Manager.radaSKHVip[Util.nextInt(0, 5)];
                if (player.getSession().bdPlayer > 0 && Util.isTrue(1, (int) (100 / player.getSession().bdPlayer))) {
                    itemId = Manager.radaSKHVip[6];
                }
            } else {
                itemId = Manager.doSKHVip[itemTS.template.gender][itemTS.template.type][Util.nextInt(0, 5)];
                if (player.getSession().bdPlayer > 0 && Util.isTrue(1, (int) (100 / player.getSession().bdPlayer))) {
                    itemId = Manager.doSKHVip[itemTS.template.gender][itemTS.template.type][6];
                }
            }
            int skhId = ItemService.gI().randomSKHId(itemTS.template.gender);
            Item item;
            if (new Item(itemId).isDTL()) {
                item = Util.ratiItemTL(itemId);
                item.itemOptions.add(new Item.ItemOption(skhId, 1));
                item.itemOptions.add(new Item.ItemOption(ItemService.gI().optionIdSKH(skhId), 1));
                item.itemOptions.remove(item.itemOptions.stream().filter(itemOption -> itemOption.optionTemplate.id == 21).findFirst().get());
                item.itemOptions.add(new Item.ItemOption(21, 15));
                item.itemOptions.add(new Item.ItemOption(30, 1));
            } else {
                item = ItemService.gI().itemSKH(itemId, skhId);
            }
            InventoryServiceNew.gI().addItemBag(player, item);
            InventoryServiceNew.gI().subQuantityItemsBag(player, itemTS, 1);
            itemSKH.forEach(i -> InventoryServiceNew.gI().subQuantityItemsBag(player, i, 1));
            InventoryServiceNew.gI().sendItemBags(player);
            Service.getInstance().sendMoney(player);
            player.combineNew.itemsCombine.clear();
            reOpenItemCombine(player);
        } else {
            Service.getInstance().sendThongBao(player, "Bạn phải có ít nhất 1 ô trống hành trang");
        }
    }

    private void doiVeHuyDiet(Player player) {
        if (player.combineNew.itemsCombine.size() == 1) {
            Item item = player.combineNew.itemsCombine.get(0);
            if (item.isNotNullItem() && item.template.id >= 555 && item.template.id <= 567) {
                if (InventoryServiceNew.gI().getCountEmptyBag(player) > 0
                        && player.inventory.gold >= COST_DOI_VE_DOI_DO_HUY_DIET) {
                    player.inventory.gold -= COST_DOI_VE_DOI_DO_HUY_DIET;
                    Item ticket = ItemService.gI().createNewItem((short) (2001 + item.template.type));
                    ticket.itemOptions.add(new Item.ItemOption(30, 0));
                    InventoryServiceNew.gI().subQuantityItemsBag(player, item, 1);
                    InventoryServiceNew.gI().addItemBag(player, ticket);
                    sendEffectOpenItem(player, item.template.iconID, ticket.template.iconID);

                    InventoryServiceNew.gI().sendItemBags(player);
                    Service.getInstance().sendMoney(player);
                    reOpenItemCombine(player);
                }
            }
        }
    }

    private void epSaoTrangBi(Player player) {
        if (player.combineNew.itemsCombine.size() == 2) {
            int gem = player.combineNew.gemCombine;
            if (player.inventory.gem < gem) {
                Service.getInstance().sendThongBao(player, "Không đủ ngọc để thực hiện");
                return;
            }
            Item trangBi = null;
            Item daPhaLe = null;
            for (Item item : player.combineNew.itemsCombine) {
                if (isTrangBiEpPhaLeHoa(item)) {
                    trangBi = item;
                } else if (isDaPhaLe(item)) {
                    daPhaLe = item;
                }
            }
            int star = 0; //sao pha lê đã ép
            int starEmpty = 0; //lỗ sao pha lê
            if (trangBi != null && daPhaLe != null) {
                Item.ItemOption optionStar = null;
                for (Item.ItemOption io : trangBi.itemOptions) {
                    if (io.optionTemplate.id == 102) {
                        star = io.param;
                        optionStar = io;
                    } else if (io.optionTemplate.id == 107) {
                        starEmpty = io.param;
                    }
                }
                if (star < starEmpty) {
                    player.inventory.gem -= gem;
                    int optionId = getOptionDaPhaLe(daPhaLe);
                    int param = getParamDaPhaLe(daPhaLe);
                    Item.ItemOption option = null;
                    for (Item.ItemOption io : trangBi.itemOptions) {
                        if (io.optionTemplate.id == optionId) {
                            option = io;
                            break;
                        }
                    }
                    if (option != null) {
                        option.param += param;
                    } else {
                        trangBi.itemOptions.add(new Item.ItemOption(optionId, param));
                    }
                    if (optionStar != null) {
                        optionStar.param++;
                    } else {
                        trangBi.itemOptions.add(new Item.ItemOption(102, 1));
                    }

                    InventoryServiceNew.gI().subQuantityItemsBag(player, daPhaLe, 1);
                    sendEffectSuccessCombine(player);
                }
                InventoryServiceNew.gI().sendItemBags(player);
                Service.getInstance().sendMoney(player);
                reOpenItemCombine(player);
            }
        }
    }

    private void epDaDanhHieu(Player player) {
        if (player.combineNew.itemsCombine.size() == 2) {
            int gem = player.combineNew.gemCombine;
            if (player.inventory.gem < gem) {
                Service.getInstance().sendThongBao(player, "Không đủ ngọc để thực hiện");
                return;
            }
            Item DanhHieu = null;
            Item daPhaLe = null;
            for (Item item : player.combineNew.itemsCombine) {
                if (isDanhHieuPhaLeHoa(item)) {
                    DanhHieu = item;
                } else if (isDaPhaLe100(item)) {
                    daPhaLe = item;
                }
            }
            int star = 0; //sao pha lê đã ép
            int starEmpty = 0; //lỗ sao pha lê
            if (DanhHieu != null && daPhaLe != null) {
                Item.ItemOption optionStar = null;
                for (Item.ItemOption io : DanhHieu.itemOptions) {
                    if (io.optionTemplate.id == 102) {
                        star = io.param;
                        optionStar = io;
                    } else if (io.optionTemplate.id == 107) {
                        starEmpty = io.param;
                    }
                }
                if (star < starEmpty) {
                    player.inventory.gem -= gem;
                    int optionId = getOptionDaPhaLe(daPhaLe);
                    int param = getParamDaPhaLe(daPhaLe);
                    Item.ItemOption option = null;
                    for (Item.ItemOption io : DanhHieu.itemOptions) {
                        if (io.optionTemplate.id == optionId) {
                            option = io;
                            break;
                        }
                    }
                    if (option != null) {
                        option.param += param;
                    } else {
                        DanhHieu.itemOptions.add(new Item.ItemOption(optionId, param));
                    }
                    if (optionStar != null) {
                        optionStar.param++;
                    } else {
                        DanhHieu.itemOptions.add(new Item.ItemOption(102, 1));
                    }

                    InventoryServiceNew.gI().subQuantityItemsBag(player, daPhaLe, 1);
                    sendEffectSuccessCombine(player);
                }
                InventoryServiceNew.gI().sendItemBags(player);
                Service.getInstance().sendMoney(player);
                reOpenItemCombine(player);
            }
        }
    }

    private void epSaoTrangBiTC(Player player) {
        if (player.combineNew.itemsCombine.size() == 2) {
            int gem = player.combineNew.gemCombine;
            if (player.inventory.gem < gem) {
                Service.getInstance().sendThongBao(player, "Không đủ ngọc để thực hiện");
                return;
            }
            Item daPhaLe = null;
            Item Trangbi = null;
            for (Item item : player.combineNew.itemsCombine) {
                if (item.isNotNullItem()) {
                    if (item.template.type == 0
                            || item.template.type == 1
                            || item.template.type == 2
                            || item.template.type == 3
                            || item.template.type == 4) {
                        Trangbi = item;
                    } else if (isDaPhaLeTC1(item)) {
                        daPhaLe = item;
                    }

                }
            }
            int star = 0; //sao pha lê đã ép
            int starEmpty = 0; //lỗ sao pha lê
            int level_216 = 0;
            Item.ItemOption optionLevel_216 = null;

            for (Item.ItemOption io : Trangbi.itemOptions) {
                if (io.optionTemplate.id == 216) {
                    level_216 = io.param;
                    optionLevel_216 = io;
                    break;
                }
            }

            if (Trangbi != null && daPhaLe != null && optionLevel_216 != null) {
                Item.ItemOption optionStar = null;
                for (Item.ItemOption io : Trangbi.itemOptions) {
                    if (io.optionTemplate.id == 102) {
                        star = io.param;
                        optionStar = io;
                    } else if (io.optionTemplate.id == 107) {
                        starEmpty = io.param;
                    }
                }
                if (star < starEmpty) {
                    player.inventory.gem -= gem;
                    int optionId = getOptionDaPhaLeTC1(daPhaLe);
                    int param = getParamDaPhaLeTC1(daPhaLe);
                    Item.ItemOption option = null;
                    for (Item.ItemOption io : Trangbi.itemOptions) {
                        if (io.optionTemplate.id == optionId) {
                            option = io;
                            break;
                        }
                    }
                    if (option != null) {
                        option.param += param;
                    } else {
                        Trangbi.itemOptions.add(new Item.ItemOption(optionId, param));
                    }
                    if (optionStar != null) {
                        optionStar.param++;
                    } else {
                        Trangbi.itemOptions.add(new Item.ItemOption(102, 1));
                    }

                    InventoryServiceNew.gI().subQuantityItemsBag(player, daPhaLe, 1);
//                    sendEffectSuccessCombine(player);
                }
                InventoryServiceNew.gI().sendItemBags(player);
                Service.getInstance().sendMoney(player);
                reOpenItemCombine(player);
            }
        }
    }

    private void phaLeHoaTrangBi(Player player) {
        boolean flag = false;
        int solandap = player.combineNew.quantities;
        while (player.combineNew.quantities > 0 && !player.combineNew.itemsCombine.isEmpty() && !flag) {
            int gold = player.combineNew.goldCombine;
            int gem = player.combineNew.gemCombine;
            if (player.inventory.gold < gold) {
                Service.gI().sendThongBao(player, "Không đủ vàng để thực hiện");
                break;
            } else if (player.inventory.gem < gem) {
                Service.gI().sendThongBao(player, "Không đủ ngọc để thực hiện");
                break;
            }
            Item item = player.combineNew.itemsCombine.get(0);
            if (isTrangBiPhaLeHoa(item)) {
                int star = 0;
                Item.ItemOption optionStar = null;
                for (Item.ItemOption io : item.itemOptions) {
                    if (io.optionTemplate.id == 107) {
                        star = io.param;
                        optionStar = io;
                        break;
                    }
                }
                if (star < MAX_STAR_ITEM) {
                    player.inventory.gold -= gold;
                    player.inventory.gem -= gem;
                    //float ratio = getRatioPhaLeHoa(star);
                    int epint = (int) getRatioPhaLeHoa(star);
                    byte ratio = (optionStar != null && optionStar.param >= 4) ? (byte) 1 : 1;
                    flag = Util.isTrue(epint, 10000);
                    if (flag) {
                        if (optionStar == null) {
                            item.itemOptions.add(new Item.ItemOption(107, 1));
                        } else {
                            optionStar.param++;
                        }
                        sendEffectSuccessCombine(player);
                        Service.getInstance().sendThongBao(player, "Lên cấp sau " + (solandap - player.combineNew.quantities + 1) + " lần đập");
                        if (optionStar != null && optionStar.param >= 7) {
                            ServerNotify.gI().notify("Chúc mừng " + player.name + " vừa pha lê hóa "
                                    + "thành công " + item.template.name + " lên " + optionStar.param + " sao pha lê");
                        }
                    } else {
                        sendEffectFailCombine(player);
//                        Service.gI().sendMoney(player);
                    }
                }
            }
            player.combineNew.quantities -= 1;
        }
        if (!flag) {
            sendEffectFailCombine(player);
//            Service.getInstance().sendThongBao(player, "Bạn thất bại sau" + solandap + " lần đập");
        }
        InventoryServiceNew.gI().sendItemBags(player);
        Service.gI().sendMoney(player);
        reOpenItemCombine(player);
    }

    private void phaLeHoaTrangBiThangCap(Player player) {
        if (!player.combineNew.itemsCombine.isEmpty()) {
            int gold = player.combineNew.goldCombine;
            int gem = player.combineNew.gemCombine;

            if (player.inventory.gold < gold) {
                Service.getInstance().sendThongBao(player, "Không đủ vàng để thực hiện");
                return;
            } else if (player.inventory.gem < gem) {
                Service.getInstance().sendThongBao(player, "Không đủ ngọc để thực hiện");
                return;
            }

            Item Trangbi = null;
            for (Item item : player.combineNew.itemsCombine) {
                if (item.isNotNullItem()) {
                    if (item.template.type == 0
                            || item.template.type == 1
                            || item.template.type == 2
                            || item.template.type == 3
                            || item.template.type == 4) {
                        Trangbi = item;
                    }
                }
            }

            int level_216 = 0;
            Item.ItemOption optionLevel_216 = null;

            for (Item.ItemOption io : Trangbi.itemOptions) {
                if (io.optionTemplate.id == 216) {
                    level_216 = io.param;
                    optionLevel_216 = io;
                    break;
                }
            }

            if (Trangbi != null && optionLevel_216 != null) {
                int star = 0;
                Item.ItemOption optionStar = null;
                for (Item.ItemOption io : Trangbi.itemOptions) {
                    if (io.optionTemplate.id == 107) {
                        star = io.param;
                        optionStar = io;
                        break;
                    }
                }
                if (star < MAX_STAR_ITEM_TC1) {
                    player.inventory.gold -= gold;
                    player.inventory.gem -= gem;
                    byte ratio = (optionStar != null && optionStar.param > 4) ? (byte) 2 : 1;
                    if (Util.isTrue(player.combineNew.ratioCombine, 100 * ratio)) {
                        if (optionStar == null) {
                            Trangbi.itemOptions.add(new Item.ItemOption(107, 1));
                        } else {
                            optionStar.param++;
                        }
//                        sendEffectSuccessCombine(player);
                        if (optionStar != null && optionStar.param >= 7) {
                            ServerNotify.gI().notify("Chúc mừng " + player.name + " vừa pha lê hóa "
                                    + "thành công " + Trangbi.template.name + " lên " + optionStar.param + " sao pha lê");
                        }
                    } else {
//                        sendEffectFailCombine(player);
                    }
                }
                InventoryServiceNew.gI().sendItemBags(player);
                Service.getInstance().sendMoney(player);
                reOpenItemCombine(player);
            }
        }
    }

    private void nhapNgocRong(Player player) {
        if (InventoryServiceNew.gI().getCountEmptyBag(player) > 0) {
            if (!player.combineNew.itemsCombine.isEmpty()) {
                Item item = player.combineNew.itemsCombine.get(0);
                if (item != null && item.isNotNullItem() && (item.template.id > 14 && item.template.id <= 20) && item.quantity >= 7) {
                    Item nr = ItemService.gI().createNewItem((short) (item.template.id - 1));
                    InventoryServiceNew.gI().addItemBag(player, nr);
                    InventoryServiceNew.gI().subQuantityItemsBag(player, item, 7);
                    InventoryServiceNew.gI().sendItemBags(player);
                    reOpenItemCombine(player);
                    sendEffectCombineDB(player, item.template.iconID);
                }
            }
        }
    }

//    if (InventoryServiceNew.gI().getCountEmptyBag(player) > 0) {
//            if (player.inventory.gold < COST) {
//                Service.getInstance().sendThongBao(player, "Con cần thêm vàng để pháp sư hóa...");
//                return;
//            }
//            if (player.inventory.ruby < RUBY) {
//                Service.getInstance().sendThongBao(player, "Con cần thêm hồng ngọc để pháp sư hóa...");
//                return;
//            }
//            player.inventory.gold -= COST;
//            player.inventory.ruby -= RUBY;
//    
    private void antrangbi(Player player) {
        if (InventoryServiceNew.gI().getCountEmptyBag(player) > 0) {

            if (player.inventory.gold < COST) {
                Service.getInstance().sendThongBao(player, "Con cần thêm vàng để ép ấn...");
                return;
            }
            if (player.inventory.ruby < RUBY) {
                Service.getInstance().sendThongBao(player, "Con cần thêm hồng ngọc để ép ấn...");
                return;
            }

            if (!player.combineNew.itemsCombine.isEmpty()) {
                Item item = player.combineNew.itemsCombine.get(0);
                Item dangusac = player.combineNew.itemsCombine.get(1);
                int star = 0;
                Item.ItemOption optionStar = null;
                for (Item.ItemOption io : item.itemOptions) {
                    if (io.optionTemplate.id == 34 || io.optionTemplate.id == 35 || io.optionTemplate.id == 36) {
                        star = io.param;
                        optionStar = io;
                        break;
                    }
                }
                if (item != null && item.isNotNullItem() && dangusac != null && dangusac.isNotNullItem() && (dangusac.template.id == 1232 || dangusac.template.id == 1233 || dangusac.template.id == 1234) && dangusac.quantity >= 99) {
                    if (optionStar == null) {
                        player.inventory.gold -= COST;
                        player.inventory.ruby -= RUBY;

                        if (dangusac.template.id == 1232) {
                            if (Util.isTrue(20, 100)) {
                                item.itemOptions.add(new Item.ItemOption(34, 0));
                                sendEffectSuccessCombine(player);
                            } else {
                                sendEffectFailCombine(player);
                            }
                        } else if (dangusac.template.id == 1233) {
                            if (Util.isTrue(20, 100)) {
                                item.itemOptions.add(new Item.ItemOption(35, 0));
                                sendEffectSuccessCombine(player);
                            } else {
                                sendEffectFailCombine(player);
                            }
                        } else if (dangusac.template.id == 1234) {
                            if (Util.isTrue(20, 100)) {
                                item.itemOptions.add(new Item.ItemOption(36, 0));
                                sendEffectSuccessCombine(player);
                            } else {
                                sendEffectFailCombine(player);
                            }
                        }
//                    InventoryServiceNew.gI().addItemBag(player, item);
                        InventoryServiceNew.gI().subQuantityItemsBag(player, dangusac, 99);
                        Service.getInstance().sendMoney(player);
                        InventoryServiceNew.gI().sendItemBags(player);
                        reOpenItemCombine(player);
//                    sendEffectCombineDB(player, item.template.iconID);
                    } else {
                        Service.getInstance().sendThongBao(player, "Trang bị của bạn có ấn rồi mà !!!");
                    }
                }
            }
        }
    }

    public void cheTaoDoTS(Player player) {
        // Công thức vip + x999 Mảnh thiên sứ + đá nâng cấp + đá may mắn
        if (player.combineNew.itemsCombine.size() < 2 || player.combineNew.itemsCombine.size() > 4) {
            Service.getInstance().sendThongBao(player, "Thiếu vật phẩm, vui lòng thêm vào");
            return;
        }
        if (player.combineNew.itemsCombine.stream().filter(item -> item.isNotNullItem() && item.isCongThucVip()).count() != 1) {
            Service.getInstance().sendThongBao(player, "Thiếu Công thức Vip");
            return;
        }
        if (player.combineNew.itemsCombine.stream().filter(item -> item.isNotNullItem() && item.isManhTS() && item.quantity >= 999).count() != 1) {
            Service.getInstance().sendThongBao(player, "Thiếu Mảnh thiên sứ");
            return;
        }
        if (player.combineNew.itemsCombine.size() == 3 && player.combineNew.itemsCombine.stream().filter(item -> item.isNotNullItem() && item.isDaNangCap()).count() != 1 || player.combineNew.itemsCombine.size() == 4 && player.combineNew.itemsCombine.stream().filter(item -> item.isNotNullItem() && item.isDaNangCap()).count() != 1) {
            Service.getInstance().sendThongBao(player, "Thiếu Đá nâng cấp");
            return;
        }
        if (player.combineNew.itemsCombine.size() == 3 && player.combineNew.itemsCombine.stream().filter(item -> item.isNotNullItem() && item.isDaMayMan()).count() != 1 || player.combineNew.itemsCombine.size() == 4 && player.combineNew.itemsCombine.stream().filter(item -> item.isNotNullItem() && item.isDaMayMan()).count() != 1) {
            Service.getInstance().sendThongBao(player, "Thiếu Đá may mắn");
            return;
        }
        Item mTS = null, daNC = null, daMM = null, CtVip = null;
        for (Item item : player.combineNew.itemsCombine) {
            if (item.isNotNullItem()) {
                if (item.isManhTS()) {
                    mTS = item;
                } else if (item.isDaNangCap()) {
                    daNC = item;
                } else if (item.isDaMayMan()) {
                    daMM = item;
                } else if (item.isCongThucVip()) {
                    CtVip = item;
                }
            }
        }
        if (InventoryServiceNew.gI().getCountEmptyBag(player) > 0) {//check chỗ trống hành trang
            if (player.inventory.gold < 1000000000 || player.inventory.ruby < 20000) {
                Service.getInstance().sendThongBao(player, "Không đủ vàng hoặc hồng ngọc để thực hiện");
                return;
            }
            player.inventory.gold -= 500000000;
            player.inventory.ruby -= 20000;

            int tilemacdinh = 35;
            int tileLucky = 20;
            if (daNC != null) {
                tilemacdinh += (daNC.template.id - 1073) * 10;
            } else {
                tilemacdinh = tilemacdinh;
            }
            if (daMM != null) {
                tileLucky += tileLucky * (daMM.template.id - 1078) * 10 / 100;
            } else {
                tileLucky = tileLucky;
            }

            if (Util.nextInt(0, 100) < tilemacdinh) {
                Item itemCtVip = player.combineNew.itemsCombine.stream().filter(item -> item.isNotNullItem() && item.isCongThucVip()).findFirst().get();
                if (daNC != null) {
                    Item itemDaNangC = player.combineNew.itemsCombine.stream().filter(item -> item.isNotNullItem() && item.isDaNangCap()).findFirst().get();
                }
                if (daMM != null) {
                    Item itemDaMayM = player.combineNew.itemsCombine.stream().filter(item -> item.isNotNullItem() && item.isDaMayMan()).findFirst().get();
                }
                Item itemManh = player.combineNew.itemsCombine.stream().filter(item -> item.isNotNullItem() && item.isManhTS() && item.quantity >= 999).findFirst().get();

                tilemacdinh = Util.nextInt(0, 50);
                if (tilemacdinh == 49 || tilemacdinh == 50) {
                    tilemacdinh = 20;
                } else if (tilemacdinh == 48 || tilemacdinh == 47) {
                    tilemacdinh = 19;
                } else if (tilemacdinh == 46 || tilemacdinh == 45) {
                    tilemacdinh = 18;
                } else if (tilemacdinh == 44 || tilemacdinh == 43) {
                    tilemacdinh = 17;
                } else if (tilemacdinh == 42 || tilemacdinh == 41) {
                    tilemacdinh = 16;
                } else if (tilemacdinh == 40 || tilemacdinh == 39) {
                    tilemacdinh = 15;
                } else if (tilemacdinh == 38 || tilemacdinh == 37) {
                    tilemacdinh = 14;
                } else if (tilemacdinh == 36 || tilemacdinh == 35) {
                    tilemacdinh = 13;
                } else if (tilemacdinh == 34 || tilemacdinh == 33) {
                    tilemacdinh = 12;
                } else if (tilemacdinh == 32 || tilemacdinh == 31) {
                    tilemacdinh = 11;
                } else if (tilemacdinh == 30 || tilemacdinh == 29) {
                    tilemacdinh = 10;
                } else if (tilemacdinh <= 28 || tilemacdinh >= 26) {
                    tilemacdinh = 9;
                } else if (tilemacdinh <= 25 || tilemacdinh >= 23) {
                    tilemacdinh = 8;
                } else if (tilemacdinh <= 22 || tilemacdinh >= 20) {
                    tilemacdinh = 7;
                } else if (tilemacdinh <= 19 || tilemacdinh >= 17) {
                    tilemacdinh = 6;
                } else if (tilemacdinh <= 16 || tilemacdinh >= 14) {
                    tilemacdinh = 5;
                } else if (tilemacdinh <= 13 || tilemacdinh >= 11) {
                    tilemacdinh = 4;
                } else if (tilemacdinh <= 10 || tilemacdinh >= 8) {
                    tilemacdinh = 3;
                } else if (tilemacdinh <= 7 || tilemacdinh >= 5) {
                    tilemacdinh = 2;
                } else if (tilemacdinh <= 4 || tilemacdinh >= 2) {
                    tilemacdinh = 1;
                } else if (tilemacdinh <= 1) {
                    tilemacdinh = 0;
                }
                {
                    tilemacdinh = 0;
                }
                short[][] itemIds = {{1048, 1051, 1054, 1057, 1060}, {1049, 1052, 1055, 1058, 1061}, {1050, 1053, 1056, 1059, 1062}}; // thứ tự td - 0,nm - 1, xd - 2

                Item itemTS = ItemService.gI().DoThienSu(itemIds[itemCtVip.template.gender > 2 ? player.gender : itemCtVip.template.gender][itemManh.typeIdManh()], itemCtVip.template.gender);

                tilemacdinh += 10;

                if (tilemacdinh > 0) {
                    for (byte i = 0; i < itemTS.itemOptions.size(); i++) {
                        if (itemTS.itemOptions.get(i).optionTemplate.id != 21 && itemTS.itemOptions.get(i).optionTemplate.id != 30) {
                            itemTS.itemOptions.get(i).param += (itemTS.itemOptions.get(i).param * tilemacdinh / 100);
                        }
                    }
                }
                tilemacdinh = Util.nextInt(0, 100);

                if (tilemacdinh <= tileLucky) {
                    if (tilemacdinh >= (tileLucky - 3)) {
                        tileLucky = 3;
                    } else if (tilemacdinh <= (tileLucky - 4) && tilemacdinh >= (tileLucky - 7)) {
                        tileLucky = 2;
                    } else {
                        tileLucky = 1;
                    }
//                        itemTS.itemOptions.add(new Item.ItemOption(15, tileLucky));
                    ArrayList<Integer> listOptionBonus = new ArrayList<>();
                    listOptionBonus.add(50);
                    listOptionBonus.add(77);
                    listOptionBonus.add(103);
                    listOptionBonus.add(98);
                    listOptionBonus.add(99);
                    listOptionBonus.add(218);

                    for (int i = 0; i < tileLucky; i++) {
                        tilemacdinh = Util.nextInt(0, listOptionBonus.size());
                        itemTS.itemOptions.add(new ItemOption(listOptionBonus.get(tilemacdinh), Util.nextInt(5, 20)));
                        listOptionBonus.remove(tilemacdinh);
                    }
                }

                InventoryServiceNew.gI().addItemBag(player, itemTS);
                sendEffectSuccessCombine(player);
            } else {
                sendEffectFailCombine(player);
            }
            if (mTS != null && daMM != null && daNC != null && CtVip != null) {
                InventoryServiceNew.gI().subQuantityItemsBag(player, CtVip, 1);
                InventoryServiceNew.gI().subQuantityItemsBag(player, daNC, 1);
                InventoryServiceNew.gI().subQuantityItemsBag(player, mTS, 999);
                InventoryServiceNew.gI().subQuantityItemsBag(player, daMM, 1);
            } else if (CtVip != null && mTS != null) {
                InventoryServiceNew.gI().subQuantityItemsBag(player, CtVip, 1);
                InventoryServiceNew.gI().subQuantityItemsBag(player, mTS, 999);
            } else if (CtVip != null && mTS != null && daNC != null) {
                InventoryServiceNew.gI().subQuantityItemsBag(player, CtVip, 1);
                InventoryServiceNew.gI().subQuantityItemsBag(player, mTS, 999);
                InventoryServiceNew.gI().subQuantityItemsBag(player, daNC, 1);
            } else if (CtVip != null && mTS != null && daMM != null) {
                InventoryServiceNew.gI().subQuantityItemsBag(player, CtVip, 1);
                InventoryServiceNew.gI().subQuantityItemsBag(player, mTS, 999);
                InventoryServiceNew.gI().subQuantityItemsBag(player, daMM, 1);
            }

            InventoryServiceNew.gI().sendItemBags(player);
            Service.getInstance().sendMoney(player);
            reOpenItemCombine(player);
        } else {
            Service.getInstance().sendThongBao(player, "Bạn phải có ít nhất 1 ô trống hành trang");
        }
    }

    //    private void phanradothanlinh(Player player) {
//        if (InventoryServiceNew.gI().getCountEmptyBag(player) > 0) {
//            if (!player.combineNew.itemsCombine.isEmpty()) {
//                Item item = player.combineNew.itemsCombine.get(0);
//                if (item != null && item.isNotNullItem() && (item.template.id > 0 && item.template.id <= 3) && item.quantity >= 1) {
//                    Item nr = ItemService.gI().createNewItem((short) (item.template.id - 78));
//                    InventoryServiceNew.gI().addItemBag(player, nr);
//                    InventoryServiceNew.gI().subQuantityItemsBag(player, item, 1);
//                    InventoryServiceNew.gI().sendItemBags(player);
//                    reOpenItemCombine(player);
//                    sendEffectCombineDB(player, item.template.iconID);
//                    Service.getInstance().sendThongBao(player, "Đã nhận được 1 điểm");
//
//                }
//            }
//        }
//    }
    private void nangCapVatPham(Player player) {
        if (player.combineNew.itemsCombine.size() >= 2 && player.combineNew.itemsCombine.size() < 4) {
            if (player.combineNew.itemsCombine.stream().filter(item -> item.isNotNullItem() && item.template.type < 5).count() != 1) {
                return;
            }
            if (player.combineNew.itemsCombine.stream().filter(item -> item.isNotNullItem() && item.template.type == 14).count() != 1) {
                return;
            }
            if (player.combineNew.itemsCombine.size() == 3 && player.combineNew.itemsCombine.stream().filter(item -> item.isNotNullItem() && item.template.id == 987).count() != 1) {
                return;//admin
            }
            Item itemDo = null; //Đổi Cải Trang V2
            Item itemDNC = null;
            Item itemDBV = null;
            for (int j = 0; j < player.combineNew.itemsCombine.size(); j++) {
                if (player.combineNew.itemsCombine.get(j).isNotNullItem()) {
                    if (player.combineNew.itemsCombine.size() == 3 && player.combineNew.itemsCombine.get(j).template.id == 987) {
                        itemDBV = player.combineNew.itemsCombine.get(j);
                        continue;
                    }
                    if (player.combineNew.itemsCombine.get(j).template.type < 5) {
                        itemDo = player.combineNew.itemsCombine.get(j);
                    } else {
                        itemDNC = player.combineNew.itemsCombine.get(j);
                    }
                }
            }
            if (isCoupleItemNangCapCheck(itemDo, itemDNC)) {
                int countDaNangCap = player.combineNew.countDaNangCap;
                int gold = player.combineNew.goldCombine;
                short countDaBaoVe = player.combineNew.countDaBaoVe;
                if (player.inventory.gold < gold) {
                    Service.getInstance().sendThongBao(player, "Không đủ vàng để thực hiện");
                    return;
                }

                if (itemDNC.quantity < countDaNangCap) {
                    return;
                }
                if (player.combineNew.itemsCombine.size() == 3) {
                    if (Objects.isNull(itemDBV)) {
                        return;
                    }
                    if (itemDBV.quantity < countDaBaoVe) {
                        return;
                    }
                }

                int level = 0;
                Item.ItemOption optionLevel = null;
                for (Item.ItemOption io : itemDo.itemOptions) {
                    if (io.optionTemplate.id == 72) {
                        level = io.param;
                        optionLevel = io;
                        break;
                    }
                }

                if (level < MAX_LEVEL_ITEM) {
                    player.inventory.gold -= gold;
                    Item.ItemOption option = null;
                    Item.ItemOption option2 = null;
                    for (Item.ItemOption io : itemDo.itemOptions) {
                        if (io.optionTemplate.id == 47
                                || io.optionTemplate.id == 6
                                || io.optionTemplate.id == 0
                                || io.optionTemplate.id == 7
                                || io.optionTemplate.id == 14
                                || io.optionTemplate.id == 22
                                || io.optionTemplate.id == 23
                                || io.optionTemplate.id == 43
                                || io.optionTemplate.id == 44) {
                            option = io;
                        } else if (io.optionTemplate.id == 27
                                || io.optionTemplate.id == 28) {
                            option2 = io;
                        }
                    }
                    if (Util.isTrue(player.combineNew.ratioCombine, 100)) {
                        option.param += (option.param * 10 / 100);
                        if (option2 != null) {
                            option2.param += (option2.param * 10 / 100);
                        }
                        if (optionLevel == null) {
                            itemDo.itemOptions.add(new Item.ItemOption(72, 1));
                        } else {
                            optionLevel.param++;
                        }
                        if (optionLevel != null && optionLevel.param >= 5) {
                            ServerNotify.gI().notify("Chúc mừng " + player.name + " vừa nâng cấp "
                                    + "thành công " + itemDo.template.name + " lên +" + optionLevel.param);
                        }
                        sendEffectSuccessCombine(player);
                    } else {
                        if ((level == 2 || level == 4 || level == 6) && (player.combineNew.itemsCombine.size() != 3)) {
                            option.param -= (option.param * 10 / 100);
                            if (option2 != null) {
                                option2.param -= (option2.param * 10 / 100);
                            }
                            optionLevel.param--;
                        }
                        sendEffectFailCombine(player);
                    }
                    if (player.combineNew.itemsCombine.size() == 3) {
                        InventoryServiceNew.gI().subQuantityItemsBag(player, itemDBV, countDaBaoVe);
                    }
                    InventoryServiceNew.gI().subQuantityItemsBag(player, itemDNC, player.combineNew.countDaNangCap);
                    InventoryServiceNew.gI().sendItemBags(player);
                    Service.getInstance().sendMoney(player);
                    reOpenItemCombine(player);
                }
            }
        }
    }

    private void EpChungNhanXuatSu(Player player) {
        if (player.combineNew.itemsCombine.size() == 2) {
            Item Porata = null;
            Item CNXuatSu = null;
            for (Item item : player.combineNew.itemsCombine) {
                if (item.template.id == 921 || item.template.id == 1155 || item.template.id == 1156) {
                    Porata = item;
                } else if (item.template.id == 720) {
                    CNXuatSu = item;
                }
            }

            int level_41 = 0;
            Item.ItemOption optionLevel_41 = null;
            for (Item.ItemOption io : Porata.itemOptions) {
                if (io.optionTemplate.id == 41) {
                    level_41 = io.param;
                    optionLevel_41 = io;
                    break;
                }
            }

            if (Porata != null && CNXuatSu != null && level_41 < 30) {

                int gold = player.combineNew.goldCombine;
                int gem = player.combineNew.gemCombine;
                if (player.inventory.gold < gold) {
                    Service.getInstance().sendThongBao(player, "Không đủ vàng để thực hiện");
                    return;
                }
                if (player.inventory.gem < gem) {
                    Service.getInstance().sendThongBao(player, "Không đủ ngọc để thực hiện");
                    return;
                }

                if (level_41 < MAX_EP_CHUNG_NHAN) {
                    player.inventory.gold -= gold;
                    player.inventory.gem -= gem;

                    if (Util.isTrue(100, 100)) {

                        if (optionLevel_41 == null) {
                            Porata.itemOptions.add(new Item.ItemOption(41, 1));
                        } else {
                            optionLevel_41.param++;
                        }
                        if (optionLevel_41 != null && optionLevel_41.param >= 20) {
                            ServerNotify.gI().notify("Chúc mừng " + player.name + " vừa nâng cấp "
                                    + "thành công " + Porata.template.name + " lên +" + optionLevel_41.param);
                        }
                        sendEffectSuccessCombine(player);
                    }
                    InventoryServiceNew.gI().subQuantityItemsBag(player, CNXuatSu, 1);
                    InventoryServiceNew.gI().sendItemBags(player);
                    Service.getInstance().sendMoney(player);
                    reOpenItemCombine(player);
                } else {
                    this.baHatMit.createOtherMenu(player, ConstNpc.IGNORE_MENU, "Bông tai đã ép chứng nhận tối đa", "Đóng");
                }
            }
        }
    }

    public void nangCapChanMenh(Player player) {
        if (player.combineNew.itemsCombine.size() != 2) {
            Service.gI().sendThongBao(player, "Thiếu nguyên liệu");
            return;
        }
        if (player.combineNew.itemsCombine.stream()
                .filter(item -> item.isNotNullItem() && (item.template.id >= 1328 && item.template.id <= 1335))
                .count() != 1) {
            Service.gI().sendThongBao(player, "Chân mệnh");
            return;
        }
        if (player.combineNew.itemsCombine.stream().filter(item -> item.isNotNullItem() && item.template.id == 674)
                .count() != 1) {
            Service.gI().sendThongBao(player, "Thiếu đá ngủ sắc");
            return;
        }

        Item chanMenh = null;
        Item ngoc1sao = null;

        for (Item item : player.combineNew.itemsCombine) {
            if (item.template.id >= 1328 && item.template.id <= 1335) {
                chanMenh = item;
            } else if (item.template.id == 674) {
                ngoc1sao = item;
            }
        }

        if (chanMenh != null && ngoc1sao != null && ngoc1sao.quantity >= 99 && player.inventory.ruby > 1000) {
            player.inventory.ruby -= 1000;
            player.inventory.gem -= 0;
            Item chanMenhMoi = ItemService.gI().createNewItem((short) (chanMenh.template.id + 1));
            int capChanMenh = chanMenhMoi.template.id - 1328;
            if (Util.isTrue(1, 100)) {
                chanMenhMoi.itemOptions.add(new ItemOption(50, 5 + capChanMenh * 2));
            }
            chanMenhMoi.itemOptions.add(new ItemOption(77, 5 + capChanMenh * 2));
            chanMenhMoi.itemOptions.add(new ItemOption(103, 5 + capChanMenh * 2));
            chanMenhMoi.itemOptions.add(new ItemOption(5, 5 + capChanMenh));
            chanMenhMoi.itemOptions.add(new ItemOption(14, 5 + capChanMenh));
            InventoryServiceNew.gI().addItemBag(player, chanMenhMoi);
            Service.gI().sendThongBao(player, "|7|Bạn nhận được " + chanMenhMoi.template.name);
            InventoryServiceNew.gI().subQuantityItemsBag(player, ngoc1sao, 99);
            InventoryServiceNew.gI().subQuantityItemsBag(player, chanMenh, 1);
            sendEffectSuccessCombine(player);
            InventoryServiceNew.gI().sendItemBags(player);
            Service.gI().sendMoney(player);
            reOpenItemCombine(player);
        } else {
            Service.gI().sendThongBao(player, "Không đủ nguyên liệu nâng cấp!");
            reOpenItemCombine(player);
        }
    }

    private void nangCapBongTai(Player player) {
        if (player.combineNew.itemsCombine.size() == 2) {
            int gold = player.combineNew.goldCombine;
            if (player.inventory.gold < gold) {
                Service.gI().sendThongBao(player, "Không đủ vàng để thực hiện");
                return;
            }
            int gem = player.combineNew.gemCombine;
            if (player.inventory.gem < gem) {
                Service.gI().sendThongBao(player, "Không đủ ngọc để thực hiện");
                return;
            }
            Item bongTai = null;
            Item manhVo = null;
            for (Item item : player.combineNew.itemsCombine) {
                if (item.template.id == 454) {
                    bongTai = item;
                } else if (item.template.id == 933) {
                    manhVo = item;
                }
            }
            if (bongTai != null && manhVo != null && manhVo.quantity >= 99) {
                player.inventory.gold -= gold;
                player.inventory.gem -= gem;
                InventoryServiceNew.gI().subQuantityItemsBag(player, manhVo, 99);
                if (Util.isTrue(player.combineNew.ratioCombine, 100)) {
                    bongTai.template = ItemService.gI().getTemplate(921);
                    bongTai.itemOptions.add(new Item.ItemOption(72, 2));
                    sendEffectSuccessCombine(player);
                } else {
                    sendEffectFailCombine(player);
                }
                InventoryServiceNew.gI().sendItemBags(player);
                Service.gI().sendMoney(player);
                reOpenItemCombine(player);
            }
        }
    }

    private void moChiSoBongTai(Player player) {
        if (player.combineNew.itemsCombine.size() == 3) {
            int gold = player.combineNew.goldCombine;
            if (player.inventory.gold < gold) {
                Service.gI().sendThongBao(player, "Không đủ vàng để thực hiện");
                return;
            }
            int gem = player.combineNew.gemCombine;
            if (player.inventory.gem < gem) {
                Service.gI().sendThongBao(player, "Không đủ ngọc để thực hiện");
                return;
            }
            Item bongtai = null;
            Item honbongtai = null;
            Item daxanhlam = null;
            for (Item item : player.combineNew.itemsCombine) {
                if (item.template.id == 921) {
                    bongtai = item;
                } else if (item.template.id == 934) {
                    honbongtai = item;
                } else if (item.template.id == 935) {
                    daxanhlam = item;
                }
            }
            if (bongtai != null && honbongtai != null && honbongtai.quantity >= 99) {
                player.inventory.gold -= gold;
                player.inventory.gem -= gem;
                InventoryServiceNew.gI().subQuantityItemsBag(player, honbongtai, 99);
                InventoryServiceNew.gI().subQuantityItemsBag(player, daxanhlam, 1);
                if (Util.isTrue(player.combineNew.ratioCombine, 100)) {
                    bongtai.itemOptions.clear();
                    bongtai.itemOptions.add(new Item.ItemOption(72, 2));
                    int rdUp = Util.nextInt(0, 7);
                    if (rdUp == 0) {
                        bongtai.itemOptions.add(new Item.ItemOption(50, Util.nextInt(5, 25)));
                    } else if (rdUp == 1) {
                        bongtai.itemOptions.add(new Item.ItemOption(77, Util.nextInt(5, 25)));
                    } else if (rdUp == 2) {
                        bongtai.itemOptions.add(new Item.ItemOption(103, Util.nextInt(5, 25)));
                    } else if (rdUp == 3) {
                        bongtai.itemOptions.add(new Item.ItemOption(108, Util.nextInt(5, 25)));
                    } else if (rdUp == 4) {
                        bongtai.itemOptions.add(new Item.ItemOption(94, Util.nextInt(5, 15)));
                    } else if (rdUp == 5) {
                        bongtai.itemOptions.add(new Item.ItemOption(14, Util.nextInt(5, 15)));
                    } else if (rdUp == 6) {
                        bongtai.itemOptions.add(new Item.ItemOption(80, Util.nextInt(5, 25)));
                    } else if (rdUp == 7) {
                        bongtai.itemOptions.add(new Item.ItemOption(81, Util.nextInt(5, 25)));
                    }
                    sendEffectSuccessCombine(player);
                } else {
                    sendEffectFailCombine(player);
                }
                InventoryServiceNew.gI().sendItemBags(player);
                Service.gI().sendMoney(player);
                reOpenItemCombine(player);
            }
        }
    }

    private void nangCapBongTaicap3(Player player) {
        if (player.combineNew.itemsCombine.size() == 2) {
            int gold = player.combineNew.goldCombine;
            if (player.inventory.gold < gold) {
                Service.gI().sendThongBao(player, "Không đủ vàng để thực hiện");
                return;
            }
            int gem = player.combineNew.gemCombine;
            if (player.inventory.gem < gem) {
                Service.gI().sendThongBao(player, "Không đủ ngọc để thực hiện");
                return;
            }
            int ruby = player.combineNew.rubyCombine;
            if (player.inventory.ruby < ruby) {
                Service.gI().sendThongBao(player, "Không đủ  hồng ngọc để thực hiện");
                return;
            }
            Item bongTai = null;
            Item manhVo = null;
            for (Item item : player.combineNew.itemsCombine) {
                if (item.template.id == 921) {
                    bongTai = item;
                } else if (item.template.id == 933) {
                    manhVo = item;
                }
            }
            if (bongTai != null && manhVo != null && manhVo.quantity >= 999) {
                player.inventory.gold -= gold;
                player.inventory.gem -= gem;
                player.inventory.ruby -= ruby;
                InventoryServiceNew.gI().subQuantityItemsBag(player, manhVo, 999);
                if (Util.isTrue(player.combineNew.ratioCombine, 100)) {
                    bongTai.template = ItemService.gI().getTemplate(1155);
                    bongTai.itemOptions.add(new Item.ItemOption(72, 3));
                    sendEffectSuccessCombine(player);
                } else {
                    sendEffectFailCombine(player);
                }
                InventoryServiceNew.gI().sendItemBags(player);
                Service.gI().sendMoney(player);
                reOpenItemCombine(player);
            }
        }
    }

    private void moChiSoBongTaicap3(Player player) {
        if (player.combineNew.itemsCombine.size() == 3) {
            int gold = player.combineNew.goldCombine;
            if (player.inventory.gold < gold) {
                Service.gI().sendThongBao(player, "Không đủ vàng để thực hiện");
                return;
            }
            int gem = player.combineNew.gemCombine;
            if (player.inventory.gem < gem) {
                Service.gI().sendThongBao(player, "Không đủ ngọc để thực hiện");
                return;
            }
            Item bongtai = null;
            Item thachPhu = null;
            Item daxanhlam = null;
            for (Item item : player.combineNew.itemsCombine) {
                if (item.template.id == 1155) {
                    bongtai = item;
                } else if (item.template.id == 934) {
                    thachPhu = item;
                } else if (item.template.id == 935) {
                    daxanhlam = item;
                }
            }
            if (bongtai != null && thachPhu != null && thachPhu.quantity >= 499) {
                player.inventory.gold -= gold;
                player.inventory.gem -= gem;
                InventoryServiceNew.gI().subQuantityItemsBag(player, thachPhu, 499);
                InventoryServiceNew.gI().subQuantityItemsBag(player, daxanhlam, 1);
                if (Util.isTrue(player.combineNew.ratioCombine, 100)) {
                    bongtai.itemOptions.clear();
                    bongtai.itemOptions.add(new Item.ItemOption(72, 3));
                    int rdUp = Util.nextInt(0, 7);
                    if (rdUp == 0) {
                        bongtai.itemOptions.add(new Item.ItemOption(50, Util.nextInt(5, 20)));
                    } else if (rdUp == 1) {
                        bongtai.itemOptions.add(new Item.ItemOption(77, Util.nextInt(5, 20)));
                    } else if (rdUp == 2) {
                        bongtai.itemOptions.add(new Item.ItemOption(103, Util.nextInt(5, 20)));
                    } else if (rdUp == 3) {
                        bongtai.itemOptions.add(new Item.ItemOption(108, Util.nextInt(5, 20)));
                    } else if (rdUp == 4) {
                        bongtai.itemOptions.add(new Item.ItemOption(94, Util.nextInt(5, 15)));
                    } else if (rdUp == 5) {
                        bongtai.itemOptions.add(new Item.ItemOption(14, Util.nextInt(5, 15)));
                    } else if (rdUp == 6) {
                        bongtai.itemOptions.add(new Item.ItemOption(80, Util.nextInt(5, 20)));
                    } else if (rdUp == 7) {
                        bongtai.itemOptions.add(new Item.ItemOption(81, Util.nextInt(5, 20)));
                    }
                    sendEffectSuccessCombine(player);
                } else {
                    sendEffectFailCombine(player);
                }
                InventoryServiceNew.gI().sendItemBags(player);
                Service.gI().sendMoney(player);
                reOpenItemCombine(player);
            }
        }
    }

    private void nangCapBongTaicap4(Player player) {
        if (player.combineNew.itemsCombine.size() == 2) {
            int gold = player.combineNew.goldCombine;
            if (player.inventory.gold < gold) {
                Service.gI().sendThongBao(player, "Không đủ vàng để thực hiện");
                return;
            }
            int gem = player.combineNew.gemCombine;
            if (player.inventory.gem < gem) {
                Service.gI().sendThongBao(player, "Không đủ ngọc để thực hiện");
                return;
            }
            int ruby = player.combineNew.rubyCombine;
            if (player.inventory.ruby < ruby) {
                Service.gI().sendThongBao(player, "Không đủ  hồng ngọc để thực hiện");
                return;
            }
            Item bongTai = null;
            Item manhVo = null;
            for (Item item : player.combineNew.itemsCombine) {
                if (item.template.id == 1155) {
                    bongTai = item;
                } else if (item.template.id == 933) {
                    manhVo = item;
                }
            }
            if (bongTai != null && manhVo != null && manhVo.quantity >= 999) {
                player.inventory.gold -= gold;
                player.inventory.gem -= gem;
                player.inventory.ruby -= ruby;
                InventoryServiceNew.gI().subQuantityItemsBag(player, manhVo, 999);
                if (Util.isTrue(player.combineNew.ratioCombine, 100)) {
                    bongTai.template = ItemService.gI().getTemplate(1156);
                    bongTai.itemOptions.add(new Item.ItemOption(72, 3));
                    sendEffectSuccessCombine(player);
                } else {
                    sendEffectFailCombine(player);
                }
                InventoryServiceNew.gI().sendItemBags(player);
                Service.gI().sendMoney(player);
                reOpenItemCombine(player);
            }
        }
    }

    private void moChiSoBongTaicap4(Player player) {
        if (player.combineNew.itemsCombine.size() == 3) {
            int gold = player.combineNew.goldCombine;
            if (player.inventory.gold < gold) {
                Service.gI().sendThongBao(player, "Không đủ vàng để thực hiện");
                return;
            }
            int gem = player.combineNew.gemCombine;
            if (player.inventory.gem < gem) {
                Service.gI().sendThongBao(player, "Không đủ ngọc để thực hiện");
                return;
            }
            Item bongtai = null;
            Item thachPhu = null;
            Item daxanhlam = null;
            for (Item item : player.combineNew.itemsCombine) {
                if (item.template.id == 1156) {
                    bongtai = item;
                } else if (item.template.id == 934) {
                    thachPhu = item;
                } else if (item.template.id == 935) {
                    daxanhlam = item;
                }
            }
            if (bongtai != null && thachPhu != null && thachPhu.quantity >= 499) {
                player.inventory.gold -= gold;
                player.inventory.gem -= gem;
                InventoryServiceNew.gI().subQuantityItemsBag(player, thachPhu, 499);
                InventoryServiceNew.gI().subQuantityItemsBag(player, daxanhlam, 1);
                if (Util.isTrue(player.combineNew.ratioCombine, 100)) {
                    bongtai.itemOptions.clear();
                    bongtai.itemOptions.add(new Item.ItemOption(72, 3));
                    int rdUp = Util.nextInt(0, 8);
                    if (rdUp == 0) {
                        bongtai.itemOptions.add(new Item.ItemOption(50, Util.nextInt(5, 25)));
                    } else if (rdUp == 1) {
                        bongtai.itemOptions.add(new Item.ItemOption(77, Util.nextInt(5, 25)));
                    } else if (rdUp == 2) {
                        bongtai.itemOptions.add(new Item.ItemOption(103, Util.nextInt(5, 25)));
                    } else if (rdUp == 3) {
                        bongtai.itemOptions.add(new Item.ItemOption(108, Util.nextInt(5, 25)));
                    } else if (rdUp == 4) {
                        bongtai.itemOptions.add(new Item.ItemOption(94, Util.nextInt(5, 15)));
                    } else if (rdUp == 5) {
                        bongtai.itemOptions.add(new Item.ItemOption(14, Util.nextInt(5, 15)));
                    } else if (rdUp == 6) {
                        bongtai.itemOptions.add(new Item.ItemOption(80, Util.nextInt(5, 25)));
                    } else if (rdUp == 7) {
                        bongtai.itemOptions.add(new Item.ItemOption(81, Util.nextInt(5, 25)));
                    } else if (rdUp == 8) {
                        bongtai.itemOptions.add(new Item.ItemOption(5, Util.nextInt(5, 25)));
                    }
                    sendEffectSuccessCombine(player);
                } else {
                    sendEffectFailCombine(player);
                }
                InventoryServiceNew.gI().sendItemBags(player);
                Service.gI().sendMoney(player);
                reOpenItemCombine(player);
            }
        }
    }

    private void moChiSoBiTich(Player player) {
        if (player.combineNew.itemsCombine.size() == 1) {
            int gold = player.combineNew.goldCombine;
            if (player.inventory.gold < gold) {
                Service.gI().sendThongBao(player, "Không đủ vàng để thực hiện");
                return;
            }
            int gem = player.combineNew.gemCombine;
            if (player.inventory.gem < gem) {
                Service.gI().sendThongBao(player, "Không đủ ngọc để thực hiện");
                return;
            }

            if (player.diembitich < 300) {
                Service.gI().sendThongBao(player, "Không đủ điểm bí tịch để thực hiện");
                return;
            }

            Item BiTich = null;

            for (Item item : player.combineNew.itemsCombine) {
                if (item.template.id == 1393) {
                    BiTich = item;
                }
            }

            int level_224 = 0;
            Item.ItemOption optionLevel_224 = null;
            for (Item.ItemOption io : BiTich.itemOptions) {
                if (io.optionTemplate.id == 224) {
                    level_224 = io.param;
                    optionLevel_224 = io;
                    break;
                }
            }
            int level_225 = 0;
            Item.ItemOption optionLevel_225 = null;
            for (Item.ItemOption io : BiTich.itemOptions) {
                if (io.optionTemplate.id == 225) {
                    level_225 = io.param;
                    optionLevel_225 = io;
                    break;
                }
            }
            int level_226 = 0;
            Item.ItemOption optionLevel_226 = null;
            for (Item.ItemOption io : BiTich.itemOptions) {
                if (io.optionTemplate.id == 226) {
                    level_226 = io.param;
                    optionLevel_226 = io;
                    break;
                }
            }
            if (BiTich != null && player.diembitich >= 300) {
                player.inventory.gold -= gold;
                player.inventory.gem -= gem;
                player.diembitich -= 300;

                if (Util.isTrue(player.combineNew.ratioCombine, 100)) {
                    BiTich.itemOptions.clear();
                    int rdUp = Util.nextInt(0, 4);
                    if (rdUp == 0) {
                        if (Util.isTrue(30, 100)) {
                            BiTich.itemOptions.add(new Item.ItemOption(50, Util.nextInt(6, 10)));
                            BiTich.itemOptions.add(new Item.ItemOption(224, level_224));
                            BiTich.itemOptions.add(new Item.ItemOption(225, level_225));
                            BiTich.itemOptions.add(new Item.ItemOption(226, level_226));
                        } else {
                            BiTich.itemOptions.add(new Item.ItemOption(50, Util.nextInt(1, 5)));
                            BiTich.itemOptions.add(new Item.ItemOption(224, level_224));
                            BiTich.itemOptions.add(new Item.ItemOption(225, level_225));
                            BiTich.itemOptions.add(new Item.ItemOption(226, level_226));
                        }

                    } else if (rdUp == 1) {
                        if (Util.isTrue(30, 100)) {
                            BiTich.itemOptions.add(new Item.ItemOption(77, Util.nextInt(6, 10)));
                            BiTich.itemOptions.add(new Item.ItemOption(224, level_224));
                            BiTich.itemOptions.add(new Item.ItemOption(225, level_225));
                            BiTich.itemOptions.add(new Item.ItemOption(226, level_226));
                        } else {
                            BiTich.itemOptions.add(new Item.ItemOption(77, Util.nextInt(1, 5)));
                            BiTich.itemOptions.add(new Item.ItemOption(224, level_224));
                            BiTich.itemOptions.add(new Item.ItemOption(225, level_225));
                            BiTich.itemOptions.add(new Item.ItemOption(226, level_226));
                        }
                    } else if (rdUp == 2) {
                        if (Util.isTrue(30, 100)) {
                            BiTich.itemOptions.add(new Item.ItemOption(103, Util.nextInt(6, 10)));
                            BiTich.itemOptions.add(new Item.ItemOption(224, level_224));
                            BiTich.itemOptions.add(new Item.ItemOption(225, level_225));
                            BiTich.itemOptions.add(new Item.ItemOption(226, level_226));
                        } else {
                            BiTich.itemOptions.add(new Item.ItemOption(103, Util.nextInt(1, 5)));
                            BiTich.itemOptions.add(new Item.ItemOption(224, level_224));
                            BiTich.itemOptions.add(new Item.ItemOption(225, level_225));
                            BiTich.itemOptions.add(new Item.ItemOption(226, level_226));
                        }
                    } else if (rdUp == 3) {
                        if (Util.isTrue(30, 100)) {
                            BiTich.itemOptions.add(new Item.ItemOption(101, Util.nextInt(6, 10)));
                            BiTich.itemOptions.add(new Item.ItemOption(224, level_224));
                            BiTich.itemOptions.add(new Item.ItemOption(225, level_225));
                            BiTich.itemOptions.add(new Item.ItemOption(226, level_226));
                        } else {
                            BiTich.itemOptions.add(new Item.ItemOption(101, Util.nextInt(1, 5)));
                            BiTich.itemOptions.add(new Item.ItemOption(224, level_224));
                            BiTich.itemOptions.add(new Item.ItemOption(225, level_225));
                            BiTich.itemOptions.add(new Item.ItemOption(226, level_226));
                        }
                    } else if (rdUp == 4) {
                        if (Util.isTrue(30, 100)) {
                            BiTich.itemOptions.add(new Item.ItemOption(5, Util.nextInt(6, 10)));
                            BiTich.itemOptions.add(new Item.ItemOption(224, level_224));
                            BiTich.itemOptions.add(new Item.ItemOption(225, level_225));
                            BiTich.itemOptions.add(new Item.ItemOption(226, level_226));
                        } else {
                            BiTich.itemOptions.add(new Item.ItemOption(5, Util.nextInt(1, 5)));
                            BiTich.itemOptions.add(new Item.ItemOption(224, level_224));
                            BiTich.itemOptions.add(new Item.ItemOption(225, level_225));
                            BiTich.itemOptions.add(new Item.ItemOption(226, level_226));
                        }
                    }
                    sendEffectSuccessCombine(player);
                } else {
                    sendEffectFailCombine(player);
                }
                InventoryServiceNew.gI().sendItemBags(player);
                Service.gI().sendMoney(player);
                reOpenItemCombine(player);
            }
        }
    }

    private void doiskhthanhdns(Player player) {
        if (player.combineNew.itemsCombine.size() == 1) {
            if (player.combineNew.itemsCombine.stream().filter(item -> item.isNotNullItem() && item.isSKH()).count() != 1) {
                Service.gI().sendThongBao(player, "Thiếu đồ kích hoạt");
                return;
            }
            List<Item> itemSKH = player.combineNew.itemsCombine.stream().filter(item -> item.isNotNullItem() && item.isSKH()).collect(Collectors.toList());
            if (InventoryServiceNew.gI().getCountEmptyBag(player) > 0
                    && player.inventory.gold >= COST_DOI_KICH_HOAT) {
                player.inventory.gold -= COST_DOI_KICH_HOAT;
                int tiLe = 100;
                if (Util.isTrue(tiLe, 100)) {
                    sendEffectSuccessCombine(player);
                    Item item = ItemService.gI().createNewItem((short) 674);
                    InventoryServiceNew.gI().addItemBag(player, item);
                } else {
                    sendEffectFailCombine(player);
                }
            } else {
                Service.gI().sendThongBao(player, "Bạn không đủ vàng hoặc không đủ ô hành trang");
            }
            itemSKH.forEach(i -> InventoryServiceNew.gI().subQuantityItemsBag(player, i, 1));
            InventoryServiceNew.gI().sendItemBags(player);
            Service.getInstance().sendMoney(player);
            player.combineNew.itemsCombine.clear();
            reOpenItemCombine(player);
        }
    }

    private void Tienhoacaitrangbaby(Player player) {
        if (player.combineNew.itemsCombine.size() == 2) {
            Item CTGoHanSSJ = null;
            Item Dangusac = null;
            for (Item item_ : player.combineNew.itemsCombine) {
                if (item_.template.id == 674) {
                    Dangusac = item_;
                } else if (item_.isCTGoHanSSJ()) {
                    CTGoHanSSJ = item_;
                }
            }
            if (isCTGoHanSSJ(CTGoHanSSJ, Dangusac)) {
                int countDangusac = 500;
                int gold = 2000000000;
                int ruby = 100000;

                if (player.inventory.gold < gold) {
                    Service.getInstance().sendThongBao(player, "Không đủ vàng để thực hiện");
                    return;
                }
                if (player.inventory.ruby < ruby) {
                    Service.getInstance().sendThongBao(player, "Không đủ hồng ngọc để thực hiện");
                    return;
                }
                int level = 0;
                Item.ItemOption optionLevel = null;
                for (Item.ItemOption io : CTGoHanSSJ.itemOptions) {
                    if (io.optionTemplate.id == 72) {
                        level = io.param;
                        optionLevel = io;
                        break;
                    }
                }
                if (level == 10 && Dangusac.quantity >= 500) {
                    player.inventory.gold -= gold;
                    player.inventory.ruby -= ruby;

                    InventoryServiceNew.gI().subQuantityItemsBag(player, Dangusac, 500);
                    InventoryServiceNew.gI().subQuantityItemsBag(player, CTGoHanSSJ, 1);

                    Item item = ItemService.gI().createNewItem((short) 1216);
                    item.itemOptions.add(new Item.ItemOption(50, 70));
                    item.itemOptions.add(new Item.ItemOption(77, 70));
                    item.itemOptions.add(new Item.ItemOption(103, 70));
                    item.itemOptions.add(new Item.ItemOption(14, 30));
                    item.itemOptions.add(new Item.ItemOption(5, 50));
                    item.itemOptions.add(new Item.ItemOption(106, 1));
                    item.itemOptions.add(new Item.ItemOption(206, 2));
                    InventoryServiceNew.gI().addItemBag(player, item);
                    sendEffectSuccessCombine(player);

                    InventoryServiceNew.gI().sendItemBags(player);
                    Service.getInstance().sendMoney(player);
                    reOpenItemCombine(player);
                } else {
                    Service.getInstance().sendThongBao(player, "Thiếu Đá Ngũ Sắc");
                    return;
                }
            }
        }
    }

    private void Tienhoacaitrangblackgoku(Player player) {
        if (player.combineNew.itemsCombine.size() == 2) {
            Item CaiTrang = null;
            Item Dangusac = null;
            for (Item item_ : player.combineNew.itemsCombine) {
                if (item_.template.id == 674) {
                    Dangusac = item_;
                } else if (item_.isCTBaby()) {
                    CaiTrang = item_;
                }
            }
            if (isCTBaby(CaiTrang, Dangusac)) {
                int countDangusac = 1000;
                int gold = 2000000000;
                int ruby = 200000;

                if (player.inventory.gold < gold) {
                    Service.getInstance().sendThongBao(player, "Không đủ vàng để thực hiện");
                    return;
                }
                if (player.inventory.ruby < ruby) {
                    Service.getInstance().sendThongBao(player, "Không đủ hồng ngọc để thực hiện");
                    return;
                }
                int level = 0;
                Item.ItemOption optionLevel = null;
                for (Item.ItemOption io : CaiTrang.itemOptions) {
                    if (io.optionTemplate.id == 72) {
                        level = io.param;
                        optionLevel = io;
                        break;
                    }
                }
                if (level == 10 && Dangusac.quantity >= 1000) {
                    player.inventory.gold -= gold;
                    player.inventory.ruby -= ruby;

                    InventoryServiceNew.gI().subQuantityItemsBag(player, Dangusac, 1000);
                    InventoryServiceNew.gI().subQuantityItemsBag(player, CaiTrang, 1);

                    Item item = ItemService.gI().createNewItem((short) 1280);
                    item.itemOptions.add(new Item.ItemOption(50, Util.nextInt(130, 180)));
                    item.itemOptions.add(new Item.ItemOption(77, Util.nextInt(130, 180)));
                    item.itemOptions.add(new Item.ItemOption(103, Util.nextInt(130, 180)));
                    item.itemOptions.add(new Item.ItemOption(14, 40));
                    item.itemOptions.add(new Item.ItemOption(5, Util.nextInt(90, 120)));
                    item.itemOptions.add(new Item.ItemOption(106, 1));
                    item.itemOptions.add(new Item.ItemOption(206, 3));
                    InventoryServiceNew.gI().addItemBag(player, item);
                    sendEffectSuccessCombine(player);

                    InventoryServiceNew.gI().sendItemBags(player);
                    Service.getInstance().sendMoney(player);
                    reOpenItemCombine(player);
                } else {
                    Service.getInstance().sendThongBao(player, "Thiếu Đá Ngũ Sắc");
                    return;
                }
            }
        }
    }

    private void Tienhoacaitrangbill(Player player) {
        if (player.combineNew.itemsCombine.size() == 2) {
            Item CTGoHanSSJ = null;
            Item Dangusac = null;
            for (Item item_ : player.combineNew.itemsCombine) {
                if (item_.template.id == 674) {
                    Dangusac = item_;
                } else if (item_.isCTBlackGoku()) {
                    CTGoHanSSJ = item_;
                }
            }
            if (isCTBlackGoku(CTGoHanSSJ, Dangusac)) {
                int countDangusac = 1500;
                int gold = 2000000000;
                int ruby = 300000;

                if (player.inventory.gold < gold) {
                    Service.getInstance().sendThongBao(player, "Không đủ vàng để thực hiện");
                    return;
                }
                if (player.inventory.ruby < ruby) {
                    Service.getInstance().sendThongBao(player, "Không đủ hồng ngọc để thực hiện");
                    return;
                }
                int level = 0;
                Item.ItemOption optionLevel = null;
                for (Item.ItemOption io : CTGoHanSSJ.itemOptions) {
                    if (io.optionTemplate.id == 72) {
                        level = io.param;
                        optionLevel = io;
                        break;
                    }
                }
                if (level == 10 && Dangusac.quantity >= 1500) {
                    player.inventory.gold -= gold;
                    player.inventory.ruby -= ruby;

                    InventoryServiceNew.gI().subQuantityItemsBag(player, Dangusac, 1500);
                    InventoryServiceNew.gI().subQuantityItemsBag(player, CTGoHanSSJ, 1);

                    Item item = ItemService.gI().createNewItem((short) 2008);
                    item.itemOptions.add(new Item.ItemOption(50, Util.nextInt(200, 250)));
                    item.itemOptions.add(new Item.ItemOption(77, Util.nextInt(200, 250)));
                    item.itemOptions.add(new Item.ItemOption(103, Util.nextInt(200, 250)));
                    item.itemOptions.add(new Item.ItemOption(14, 50));
                    item.itemOptions.add(new Item.ItemOption(5, Util.nextInt(140, 170)));
                    item.itemOptions.add(new Item.ItemOption(106, 1));
                    item.itemOptions.add(new Item.ItemOption(206, 4));
                    InventoryServiceNew.gI().addItemBag(player, item);
                    sendEffectSuccessCombine(player);

                    InventoryServiceNew.gI().sendItemBags(player);
                    Service.getInstance().sendMoney(player);
                    reOpenItemCombine(player);
                } else {
                    Service.getInstance().sendThongBao(player, "Thiếu Đá Ngũ Sắc");
                    return;
                }
            }
        }
    }

    private void Tienhoacaitranggold(Player player) {
        if (player.combineNew.itemsCombine.size() == 2) {
            Item CTGoHanSSJ = null;
            Item Dangusac = null;
            for (Item item_ : player.combineNew.itemsCombine) {
                if (item_.template.id == 674) {
                    Dangusac = item_;
                } else if (item_.isCTBill()) {
                    CTGoHanSSJ = item_;
                }
            }
            if (isCTBill(CTGoHanSSJ, Dangusac)) {
                int countDangusac = 2000;
                int gold = 2000000000;
                int ruby = 400000;

                if (player.inventory.gold < gold) {
                    Service.getInstance().sendThongBao(player, "Không đủ vàng để thực hiện");
                    return;
                }
                if (player.inventory.ruby < ruby) {
                    Service.getInstance().sendThongBao(player, "Không đủ hồng ngọc để thực hiện");
                    return;
                }
                int level = 0;
                Item.ItemOption optionLevel = null;
                for (Item.ItemOption io : CTGoHanSSJ.itemOptions) {
                    if (io.optionTemplate.id == 72) {
                        level = io.param;
                        optionLevel = io;
                        break;
                    }
                }
                if (level == 10 && Dangusac.quantity >= 2000) {
                    player.inventory.gold -= gold;
                    player.inventory.ruby -= ruby;

                    InventoryServiceNew.gI().subQuantityItemsBag(player, Dangusac, 2000);
                    InventoryServiceNew.gI().subQuantityItemsBag(player, CTGoHanSSJ, 1);

                    Item item = ItemService.gI().createNewItem((short) 1208);
                    item.itemOptions.add(new Item.ItemOption(50, Util.nextInt(300, 350)));
                    item.itemOptions.add(new Item.ItemOption(77, Util.nextInt(300, 350)));
                    item.itemOptions.add(new Item.ItemOption(103, Util.nextInt(300, 350)));
                    item.itemOptions.add(new Item.ItemOption(14, 60));
                    item.itemOptions.add(new Item.ItemOption(5, Util.nextInt(200, 230)));
                    item.itemOptions.add(new Item.ItemOption(106, 1));
                    item.itemOptions.add(new Item.ItemOption(206, 5));
                    InventoryServiceNew.gI().addItemBag(player, item);
                    sendEffectSuccessCombine(player);

                    InventoryServiceNew.gI().sendItemBags(player);
                    Service.getInstance().sendMoney(player);
                    reOpenItemCombine(player);
                } else {
                    Service.getInstance().sendThongBao(player, "Thiếu Đá Ngũ Sắc");
                    return;
                }
            }
        }
    }

    private void NangCapCaiTrangSSJ(Player player) {
        if (player.combineNew.itemsCombine.size() == 2) {
            int gold = player.combineNew.goldCombine;
            if (player.inventory.gold < gold) {
                Service.gI().sendThongBao(player, "Không đủ vàng để thực hiện");
                return;
            }
            int gem = player.combineNew.gemCombine;
            if (player.inventory.gem < gem) {
                Service.gI().sendThongBao(player, "Không đủ ngọc để thực hiện");
                return;
            }
            Item caitrang = null;
            Item dangusac = null;

            for (Item item : player.combineNew.itemsCombine) {
                if (item.template.id == 1192
                        || item.template.id == 1216
                        || item.template.id == 1280
                        || item.template.id == 1208
                        || item.template.id == 2008) {
                    caitrang = item;
                } else if (item.template.id == 674) {
                    dangusac = item;
                }
            }
            int level = 0;
            Item.ItemOption optionLevel = null;
            for (Item.ItemOption io : caitrang.itemOptions) {
                if (io.optionTemplate.id == 72) {
                    level = io.param;
                    optionLevel = io;
                    break;
                }
            }
            int hp = 0;
            Item.ItemOption optionhp = null;
            for (Item.ItemOption io : caitrang.itemOptions) {
                if (io.optionTemplate.id == 77) {
                    hp = io.param;
                    optionhp = io;
                    break;
                }
            }
            int ki = 0;
            Item.ItemOption optionki = null;
            for (Item.ItemOption io : caitrang.itemOptions) {
                if (io.optionTemplate.id == 103) {
                    ki = io.param;
                    optionki = io;
                    break;
                }
            }
            int sd = 0;
            Item.ItemOption optionsd = null;
            for (Item.ItemOption io : caitrang.itemOptions) {
                if (io.optionTemplate.id == 50) {
                    sd = io.param;
                    optionsd = io;
                    break;
                }
            }
            int crit = 0;
            Item.ItemOption optioncrit = null;
            for (Item.ItemOption io : caitrang.itemOptions) {
                if (io.optionTemplate.id == 14) {
                    crit = io.param;
                    optioncrit = io;
                    break;
                }
            }
            int sdcrit = 0;
            Item.ItemOption optionsdcrit = null;
            for (Item.ItemOption io : caitrang.itemOptions) {
                if (io.optionTemplate.id == 5) {
                    sdcrit = io.param;
                    optionsdcrit = io;
                    break;
                }
            }
            if (caitrang.template.id == 1192 && dangusac != null && level < 10 && dangusac.quantity >= getDaNangCap(level)) {
                player.inventory.gold -= gold;
                player.inventory.gem -= gem;
                InventoryServiceNew.gI().subQuantityItemsBag(player, dangusac, getDaNangCap(level));
                if (Util.isTrue(player.combineNew.ratioCombine, 100)) {

                    if (optionLevel == null) {
                        caitrang.itemOptions.add(new Item.ItemOption(72, 1));
                    } else {
                        optionLevel.param++;
                    }
                    optionhp.param += Util.nextInt(10, 11);
                    optionki.param += Util.nextInt(10, 11);
                    optionsd.param += Util.nextInt(10, 11);
                    optioncrit.param += 2;
                    optionsdcrit.param += Util.nextInt(6, 7);
                    sendEffectSuccessCombine(player);
                } else {
                    sendEffectFailCombine(player);
                }
                InventoryServiceNew.gI().sendItemBags(player);
                Service.gI().sendMoney(player);
                reOpenItemCombine(player);

            } else if (caitrang.template.id == 1216 && dangusac != null && level < 10 && dangusac.quantity >= getDaNangCap(level)) {
                player.inventory.gold -= gold;
                player.inventory.gem -= gem;
                InventoryServiceNew.gI().subQuantityItemsBag(player, dangusac, getDaNangCap(level));
                if (Util.isTrue(player.combineNew.ratioCombine2, 100)) {

                    if (optionLevel == null) {
                        caitrang.itemOptions.add(new Item.ItemOption(72, 1));
                    } else {
                        optionLevel.param++;
                    }
                    optionhp.param += Util.nextInt(12, 14);
                    optionki.param += Util.nextInt(12, 14);
                    optionsd.param += Util.nextInt(12, 14);
                    optioncrit.param += 3;
                    optionsdcrit.param += Util.nextInt(8, 10);
                    sendEffectSuccessCombine(player);
                } else {
                    sendEffectFailCombine(player);
                }
                InventoryServiceNew.gI().sendItemBags(player);
                Service.gI().sendMoney(player);
                reOpenItemCombine(player);

            } else if (caitrang.template.id == 1280 && dangusac != null && level < 10 && dangusac.quantity >= getDaNangCap(level)) {
                player.inventory.gold -= gold;
                player.inventory.gem -= gem;
                InventoryServiceNew.gI().subQuantityItemsBag(player, dangusac, getDaNangCap(level));
                if (Util.isTrue(player.combineNew.ratioCombine3, 100)) {

                    if (optionLevel == null) {
                        caitrang.itemOptions.add(new Item.ItemOption(72, 1));
                    } else {
                        optionLevel.param++;
                    }
                    optionhp.param += Util.nextInt(15, 18);
                    optionki.param += Util.nextInt(15, 18);
                    optionsd.param += Util.nextInt(15, 18);
                    optioncrit.param += 4;
                    optionsdcrit.param += Util.nextInt(11, 14);
                    sendEffectSuccessCombine(player);
                } else {
                    sendEffectFailCombine(player);
                }
                InventoryServiceNew.gI().sendItemBags(player);
                Service.gI().sendMoney(player);
                reOpenItemCombine(player);

            } else if (caitrang.template.id == 2008 && dangusac != null && level < 10 && dangusac.quantity >= getDaNangCap(level)) {
                player.inventory.gold -= gold;
                player.inventory.gem -= gem;
                InventoryServiceNew.gI().subQuantityItemsBag(player, dangusac, getDaNangCap(level));
                if (Util.isTrue(player.combineNew.ratioCombine4, 100)) {

                    if (optionLevel == null) {
                        caitrang.itemOptions.add(new Item.ItemOption(72, 1));
                    } else {
                        optionLevel.param++;
                    }
                    optionhp.param += Util.nextInt(19, 23);
                    optionki.param += Util.nextInt(19, 23);
                    optionsd.param += Util.nextInt(19, 23);
                    optioncrit.param += 5;
                    optionsdcrit.param += Util.nextInt(15, 19);
                    sendEffectSuccessCombine(player);
                } else {
                    sendEffectFailCombine(player);
                }
                InventoryServiceNew.gI().sendItemBags(player);
                Service.gI().sendMoney(player);
                reOpenItemCombine(player);

            } else if (caitrang.template.id == 1208 && dangusac != null && level < 10 && dangusac.quantity >= getDaNangCap(level)) {
                player.inventory.gold -= gold;
                player.inventory.gem -= gem;
                InventoryServiceNew.gI().subQuantityItemsBag(player, dangusac, getDaNangCap(level));
                if (Util.isTrue(player.combineNew.ratioCombine5, 100)) {

                    if (optionLevel == null) {
                        caitrang.itemOptions.add(new Item.ItemOption(72, 1));
                    } else {
                        optionLevel.param++;
                    }
                    optionhp.param += Util.nextInt(25, 30);
                    optionki.param += Util.nextInt(25, 30);
                    optionsd.param += Util.nextInt(25, 30);
                    optioncrit.param += 5;
                    optionsdcrit.param += Util.nextInt(20, 25);
                    sendEffectSuccessCombine(player);
                } else {
                    sendEffectFailCombine(player);
                }
                InventoryServiceNew.gI().sendItemBags(player);
                Service.gI().sendMoney(player);
                reOpenItemCombine(player);

            } else {
                Service.gI().sendThongBao(player, "Không đủ đá ngũ sắc");
                return;
            }

        }
    }

    //--------------------------------------------------------------------------
    /**
     * r
     * Hiệu ứng mở item
     *
     * @param player
     */
    public void sendEffectOpenItem(Player player, short icon1, short icon2) {
        Message msg;
        try {
            msg = new Message(-81);
            msg.writer().writeByte(OPEN_ITEM);
            msg.writer().writeShort(icon1);
            msg.writer().writeShort(icon2);
            player.sendMessage(msg);
            msg.cleanup();
        } catch (Exception e) {
        }
    }

    /**
     * Hiệu ứng đập đồ thành công
     *
     * @param player
     */
    private void sendEffectSuccessCombine(Player player) {
        Message msg;
        try {
            msg = new Message(-81);
            msg.writer().writeByte(COMBINE_SUCCESS);
            player.sendMessage(msg);
            msg.cleanup();
        } catch (Exception e) {
        }
    }

    /**
     * Hiệu ứng đập đồ thất bại
     *
     * @param player
     */
    private void sendEffectFailCombine(Player player) {
        Message msg;
        try {
            msg = new Message(-81);
            msg.writer().writeByte(COMBINE_FAIL);
            player.sendMessage(msg);
            msg.cleanup();
        } catch (Exception e) {
        }
    }

    /**
     * Gửi lại danh sách đồ trong tab combine
     *
     * @param player
     */
    private void reOpenItemCombine(Player player) {
        Message msg;
        try {
            msg = new Message(-81);
            msg.writer().writeByte(REOPEN_TAB_COMBINE);
            msg.writer().writeByte(player.combineNew.itemsCombine.size());
            for (Item it : player.combineNew.itemsCombine) {
                for (int j = 0; j < player.inventory.itemsBag.size(); j++) {
                    if (it == player.inventory.itemsBag.get(j)) {
                        msg.writer().writeByte(j);
                    }
                }
            }
            player.sendMessage(msg);
            msg.cleanup();
        } catch (Exception e) {
        }
    }

    /**
     * Hiệu ứng ghép ngọc rồng
     *
     * @param player
     * @param icon
     */
    private void sendEffectCombineDB(Player player, short icon) {
        Message msg;
        try {
            msg = new Message(-81);
            msg.writer().writeByte(COMBINE_DRAGON_BALL);
            msg.writer().writeShort(icon);
            player.sendMessage(msg);
            msg.cleanup();
        } catch (Exception e) {
        }
    }

    //--------------------------------------------------------------------------Ratio, cost combine
    private int getGoldPhaLeHoa(int star) {
        switch (star) {
            case 0:
                return 10000000;
            case 1:
                return 25000000;
            case 2:
                return 40000000;
            case 3:
                return 60000000;
            case 4:
                return 100000000;
            case 5:
                return 140000000;
            case 6:
                return 180000000;
            case 7:
                return 220000000;
            case 8:
                return 250000000;
            case 9:
                return 300000000;
            case 10:
                return 450000000;
            case 11:
                return 500000000;
            case 12:
                return 650000000;

        }
        return 0;
    }

    private float getRatioPhaLeHoa(int star) {
        switch (star) {
            case 0:
                return 50f;
            case 1:
                return 40f;
            case 2:
                return 30f;
            case 3:
                return 15f;
            case 4:
                return 10f;
            case 5:
                return 9f;
            case 6:
                return 8f;
            case 7:
                return 7f;
            case 8:
                return 0.9f;
            case 9:
                return 0.7f;
            case 10:
                return 0.5f;
            case 11:
                return 0.3f;
            case 12:
                return 0.1f;
        }
        return 0;
    }

    private int getGemPhaLeHoa(int star) {
        switch (star) {
            case 0:
                return 10;
            case 1:
                return 20;
            case 2:
                return 30;
            case 3:
                return 40;
            case 4:
                return 50;
            case 5:
                return 60;
            case 6:
                return 70;
            case 7:
                return 80;
            case 8:
                return 100;
            case 9:
                return 100;
            case 10:
                return 200;
            case 11:
                return 200;
            case 12:
                return 500;
        }
        return 0;
    }

    private int getGemEpSao(int star) {
        switch (star) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 5;
            case 3:
                return 10;
            case 4:
                return 25;
            case 5:
                return 50;
            case 6:
                return 100;
            case 7:
                return 110;
            case 8:
                return 120;
            case 9:
                return 130;
            case 10:
                return 140;
            case 11:
                return 150;
            case 12:
                return 160;
            case 13:
                return 140;
            case 14:
                return 150;
            case 15:
                return 160;
        }
        return 0;
    }

    private double getTileNangCapDo(int level) {
        switch (level) {
            case 0:
                return 50;
            case 1:
                return 40;
            case 2:
                return 20;
            case 3:
                return 10;
            case 4:
                return 7;
            case 5:
                return 5;
            case 6:
                return 3;
            case 7: // 7 sao
                return 1;
            case 8:
                return 5;
            case 9:
                return 1;
            case 10: // 7 sao
                return 0.3;
            case 11: // 7 sao
                return 0.3;
            case 12: // 7 sao
                return 0.3;
            case 13: // 7 sao
                return 0.3;
            case 14: // 7 sao
                return 0.3;
            case 15: // 7 sao
                return 0.3;
        }
        return 0;
    }

    private int getCountDaNangCapDo(int level) {
        switch (level) {
            case 0:
                return 3;
            case 1:
                return 7;
            case 2:
                return 11;
            case 3:
                return 17;
            case 4:
                return 23;
            case 5:
                return 35;
            case 6:
                return 50;
            case 7:
                return 60;
            case 8:
                return 70;
            case 9:
                return 70;
            case 10:
                return 70;
            case 11:
                return 80;
            case 12:
                return 90;
            case 13:
                return 90;
            case 14:
                return 90;
            case 15:
                return 99;

        }
        return 0;
    }

    private int getCountDaBaoVe(int level) {
        return level + 1;
    }

    private int getGoldNangCapDo(int level) {
        switch (level) {
            case 0:
                return 10000000;
            case 1:
                return 17000000;
            case 2:
                return 30000000;
            case 3:
                return 40000000;
            case 4:
                return 70000000;
            case 5:
                return 80000000;
            case 6:
                return 100000000;
            case 7:
                return 250000000;
            case 8:
                return 10000000;
            case 9:
                return 17000000;
            case 10:
                return 30000000;
            case 11:
                return 40000000;
            case 12:
                return 70000000;
            case 13:
                return 80000000;
            case 14:
                return 100000000;
            case 15:
                return 250000000;
//                
        }
        return 0;
    }

    private float getRatioNCCaiTrang(int level) { //Tỉ lệ nâng cấp cải trang
        switch (level) {
            case 0:
                return 90f;
            case 1:
                return 60f;
            case 2:
                return 50f;
            case 3:
                return 50f;
            case 4:
                return 50f;
            case 5:
                return 40f;
            case 6:
                return 40f;
            case 7:
                return 30f;
            case 8:
                return 30f;
            case 9:
                return 20f;
            case 10:
                return 20f;
            case 11:
                return 0.6f;
            case 12:
                return 0.4f;
            case 13:
                return 0.3f;
            case 14:
                return 0.2f;
            case 15:
                return 0.1f;
        }
        return 0;
    }

    private float getRatioNCCaiTrang2(int level) { //Tỉ lệ nâng cấp cải trang
        switch (level) {
            case 0:
                return 70f;
            case 1:
                return 40f;
            case 2:
                return 30f;
            case 3:
                return 30f;
            case 4:
                return 30f;
            case 5:
                return 15f;
            case 6:
                return 15f;
            case 7:
                return 10f;
            case 8:
                return 10f;
            case 9:
                return 5f;
            case 10:
                return 3f;
            case 11:
                return 0.6f;
            case 12:
                return 0.4f;
            case 13:
                return 0.3f;
            case 14:
                return 0.2f;
            case 15:
                return 0.1f;
        }
        return 0;
    }

    private float getRatioNCCaiTrang3(int level) { //Tỉ lệ nâng cấp cải trang
        switch (level) {
            case 0:
                return 60f;
            case 1:
                return 30f;
            case 2:
                return 20f;
            case 3:
                return 20f;
            case 4:
                return 20f;
            case 5:
                return 10f;
            case 6:
                return 10f;
            case 7:
                return 5f;
            case 8:
                return 5f;
            case 9:
                return 2.5f;
            case 10:
                return 1.5f;
            case 11:
                return 0.6f;
            case 12:
                return 0.4f;
            case 13:
                return 0.3f;
            case 14:
                return 0.2f;
            case 15:
                return 0.1f;
        }
        return 0;
    }

    private float getRatioNCCaiTrang4(int level) { //Tỉ lệ nâng cấp cải trang
        switch (level) {
            case 0:
                return 50f;
            case 1:
                return 20f;
            case 2:
                return 10f;
            case 3:
                return 10f;
            case 4:
                return 10f;
            case 5:
                return 7f;
            case 6:
                return 7f;
            case 7:
                return 3f;
            case 8:
                return 3f;
            case 9:
                return 2f;
            case 10:
                return 1f;
            case 11:
                return 0.6f;
            case 12:
                return 0.4f;
            case 13:
                return 0.3f;
            case 14:
                return 0.2f;
            case 15:
                return 0.1f;
        }
        return 0;
    }

    private float getRatioNCCaiTrang5(int level) { //Tỉ lệ nâng cấp cải trang
        switch (level) {
            case 0:
                return 40f;
            case 1:
                return 15f;
            case 2:
                return 10f;
            case 3:
                return 10f;
            case 4:
                return 10f;
            case 5:
                return 5f;
            case 6:
                return 5f;
            case 7:
                return 2f;
            case 8:
                return 2f;
            case 9:
                return 1f;
            case 10:
                return 0.5f;
            case 11:
                return 0.6f;
            case 12:
                return 0.4f;
            case 13:
                return 0.3f;
            case 14:
                return 0.2f;
            case 15:
                return 0.1f;
        }
        return 0;
    }

    private int getDaNangCap(int level) {
        switch (level) {
            case 0:
                return 50;
            case 1:
                return 100;
            case 2:
                return 110;
            case 3:
                return 120;
            case 4:
                return 130;
            case 5:
                return 140;
            case 6:
                return 150;
            case 7:
                return 160;
            case 8:
                return 170;
            case 9:
                return 180;
            case 10:
                return 190;
            case 11:
                return 200;
            case 12:
                return 210;
        }
        return 0;
    }

    private int getGemNangCaiTrang(int level) {
        switch (level) {
            case 0:
                return 10000;
            case 1:
                return 20000;
            case 2:
                return 30000;
            case 3:
                return 40000;
            case 4:
                return 50000;
            case 5:
                return 60000;
            case 6:
                return 70000;
            case 7:
                return 80000;
            case 8:
                return 90000;
            case 9:
                return 100000;
            case 10:
                return 110000;
            case 11:
                return 120000;
            case 12:
                return 130000;
            case 13:
                return 140000;
            case 14:
                return 150000;
            case 15:
                return 160000;
        }
        return 0;
    }

    //--------------------------------------------------------------------------check
    private boolean isCoupleItemNangCap(Item item1, Item item2) {
        Item trangBi = null;
        Item daNangCap = null;
        if (item1 != null && item1.isNotNullItem()) {
            if (item1.template.type < 5) {
                trangBi = item1;
            } else if (item1.template.type == 14) {
                daNangCap = item1;
            }
        }
        if (item2 != null && item2.isNotNullItem()) {
            if (item2.template.type < 5) {
                trangBi = item2;
            } else if (item2.template.type == 14) {
                daNangCap = item2;
            }
        }
        if (trangBi != null && daNangCap != null) {
            if (trangBi.template.type == 0 && daNangCap.template.id == 223) {
                return true;
            } else if (trangBi.template.type == 1 && daNangCap.template.id == 222) {
                return true;
            } else if (trangBi.template.type == 2 && daNangCap.template.id == 224) {
                return true;
            } else if (trangBi.template.type == 3 && daNangCap.template.id == 221) {
                return true;
            } else if (trangBi.template.type == 4 && daNangCap.template.id == 220) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean isCoupleItemNangCapCheck(Item trangBi, Item daNangCap) {
        if (trangBi != null && daNangCap != null) {
            if (trangBi.template.type == 0 && daNangCap.template.id == 223) {
                return true;
            } else if (trangBi.template.type == 1 && daNangCap.template.id == 222) {
                return true;
            } else if (trangBi.template.type == 2 && daNangCap.template.id == 224) {
                return true;
            } else if (trangBi.template.type == 3 && daNangCap.template.id == 221) {
                return true;
            } else if (trangBi.template.type == 4 && daNangCap.template.id == 220) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean isDaPhaLe(Item item) {
        return item != null && (item.template.type == 30 || (item.template.id >= 14 && item.template.id <= 20));
    }

    private boolean isDaPhaLe100(Item item) {
        return item != null && (item.template.id == 1399);
    }

    private boolean isDaPhaLeTC1(Item item) {
        return item != null && (item.template.type == 30 || (item.template.id >= 925 && item.template.id <= 931));
    }

    private boolean isCTGoHanSSJ(Item trangBi, Item daNangCap) {
        if (trangBi != null && daNangCap != null) {
            if (trangBi.template.id == 1192 && daNangCap.template.id == 674) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean isCTBaby(Item trangBi, Item daNangCap) {
        if (trangBi != null && daNangCap != null) {
            if (trangBi.template.id == 1216 && daNangCap.template.id == 674) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean isCTBlackGoku(Item trangBi, Item daNangCap) {
        if (trangBi != null && daNangCap != null) {
            if (trangBi.template.id == 1280 && daNangCap.template.id == 674) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean isCTBill(Item trangBi, Item daNangCap) {
        if (trangBi != null && daNangCap != null) {
            if (trangBi.template.id == 2008 && daNangCap.template.id == 674) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean isTrangBiEpPhaLeHoa(Item item) {
        if (item != null && item.isNotNullItem()) {
            if (item.template.type <= 5
                    || item.template.type == 32) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean isTrangBiPhaLeHoa(Item item) {
        if (item != null && item.isNotNullItem()) {
            if (item.template.type <= 5
                    || item.template.type == 32
                    || item.template.type == 101
                    || item.template.type == 102
                    || item.template.type == 103
                    || item.template.type == 104) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean isDanhHieuPhaLeHoa(Item item) {
        if (item != null && item.isNotNullItem()) {
            if (item.template.type == 101
                    || item.template.type == 102
                    || item.template.type == 103
                    || item.template.type == 104) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean issachTuyetKy(Item item) {
        if (item != null && item.isNotNullItem()) {
            if (item.template.type == 77) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean isTrangBiAn(Item item) {
        if (item != null && item.isNotNullItem()) {
            if (item.template.id >= 1048 && item.template.id <= 1062) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean checkHaveOption(Item item, int viTriOption, int idOption) {
        if (item != null && item.isNotNullItem()) {
            if (item.itemOptions.get(viTriOption).optionTemplate.id == idOption) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private int getParamDaPhaLe(Item daPhaLe) {
        if (daPhaLe.template.type == 30 || daPhaLe.template.type == 100) {
            return daPhaLe.itemOptions.get(0).param;
        }
        switch (daPhaLe.template.id) {
            case 20:
                return 5; // +5%hp
            case 19:
                return 5; // +5%ki
            case 18:
                return 5; // +5%hp/30s
            case 17:
                return 5; // +5%ki/30s
            case 16:
                return 3; // +3%sđ
            case 15:
                return 2; // +2%giáp
            case 14:
                return 2; // +2%né đòn
            case 931:
                return 10;
            case 930:
                return 10;
            case 929:
                return 10;
            case 928:
                return 10;
            case 927:
                return 6;
            case 926:
                return 4;
            case 925:
                return 4;
            default:
                return -1;
        }
    }

    private int getOptionDaPhaLe(Item daPhaLe) {
        if (daPhaLe.template.type == 30 || daPhaLe.template.type == 100) {
            return daPhaLe.itemOptions.get(0).optionTemplate.id;
        }
        switch (daPhaLe.template.id) {
            case 20:
                return 77;
            case 19:
                return 103;
            case 18:
                return 80;
            case 17:
                return 81;
            case 16:
                return 50;
            case 15:
                return 94;
            case 14:
                return 108;
            case 931:
                return 77;
            case 930:
                return 103;
            case 929:
                return 80;
            case 928:
                return 81;
            case 927:
                return 50; // sức đánh
            case 926:
                return 94;
            case 925:
                return 108;
            default:
                return -1;
        }
    }

    private int getParamDaPhaLeTC1(Item daPhaLe) {
        if (daPhaLe.template.type == 30) {
            return daPhaLe.itemOptions.get(0).param;
        }
        switch (daPhaLe.template.id) {

            case 931:
                return 10;
            case 930:
                return 10;
            case 929:
                return 10;
            case 928:
                return 10;
            case 927:
                return 6;
            case 926:
                return 4;
            case 925:
                return 4;
            default:
                return -1;
        }
    }

    private int getOptionDaPhaLeTC1(Item daPhaLe) {
        if (daPhaLe.template.type == 30) {
            return daPhaLe.itemOptions.get(0).optionTemplate.id;
        }
        switch (daPhaLe.template.id) {
            case 931:
                return 77;
            case 930:
                return 103;
            case 929:
                return 80;
            case 928:
                return 81;
            case 927:
                return 50; // sức đánh
            case 926:
                return 94;
            case 925:
                return 108;
            default:
                return -1;
        }
    }

    /**
     * Trả về id item c0
     *
     * @param gender
     * @param type
     * @return
     */
    private int getTempIdItemC0(int gender, int type) {
        if (type == 4) {
            return 12;
        }
        switch (gender) {
            case 0:
                switch (type) {
                    case 0:
                        return 0;
                    case 1:
                        return 6;
                    case 2:
                        return 21;
                    case 3:
                        return 27;
                }
                break;
            case 1:
                switch (type) {
                    case 0:
                        return 1;
                    case 1:
                        return 7;
                    case 2:
                        return 22;
                    case 3:
                        return 28;
                }
                break;
            case 2:
                switch (type) {
                    case 0:
                        return 2;
                    case 1:
                        return 8;
                    case 2:
                        return 23;
                    case 3:
                        return 29;
                }
                break;
        }
        return -1;
    }

    private int getTempIdItemC1(int gender, int type) {
        if (type == 4) {
            return 561;
        }
        switch (gender) {
            case 0:
                switch (type) {
                    case 0:
                        return 555;
                    case 1:
                        return 556;
                    case 2:
                        return 562;
                    case 3:
                        return 563;
                }
                break;
            case 1:
                switch (type) {
                    case 0:
                        return 557;
                    case 1:
                        return 558;
                    case 2:
                        return 564;
                    case 3:
                        return 565;
                }
                break;
            case 2:
                switch (type) {
                    case 0:
                        return 559;
                    case 1:
                        return 560;
                    case 2:
                        return 566;
                    case 3:
                        return 567;
                }
                break;
        }
        return -1;
    }

    private String getNameItemC1(int gender, int type) {
        if (type == 4) {
            return "Nhẫn Thần Linh";
        }
        switch (gender) {
            case 0:
                switch (type) {
                    case 0:
                        return "Áo Thần Linh";
                    case 1:
                        return "Quần Thần Linh";
                    case 2:
                        return "Găng Thần Linh";
                    case 3:
                        return "Giầy Thần Linh";
                }
                break;
            case 1:
                switch (type) {
                    case 0:
                        return "Áo Thần Namek";
                    case 1:
                        return "Quần Thần Namek";
                    case 2:
                        return "Găng Thần Namek";
                    case 3:
                        return "Giầy Thần Namek";
                }
                break;
            case 2:
                switch (type) {
                    case 0:
                        return "Áo Thần Xayda";
                    case 1:
                        return "Quần Thần Xayda";
                    case 2:
                        return "Găng Thần Xayda";
                    case 3:
                        return "Giầy Thần Xayda";
                }
                break;
        }
        return "";
    }

    //Trả về tên đồ c0
    private String getNameItemC0(int gender, int type) {
        if (type == 4) {
            return "Rada cấp 1";
        }
        switch (gender) {
            case 0:
                switch (type) {
                    case 0:
                        return "Áo vải 3 lỗ";
                    case 1:
                        return "Quần vải đen";
                    case 2:
                        return "Găng thun đen";
                    case 3:
                        return "Giầy nhựa";
                }
                break;
            case 1:
                switch (type) {
                    case 0:
                        return "Áo sợi len";
                    case 1:
                        return "Quần sợi len";
                    case 2:
                        return "Găng sợi len";
                    case 3:
                        return "Giầy sợi len";
                }
                break;
            case 2:
                switch (type) {
                    case 0:
                        return "Áo vải thô";
                    case 1:
                        return "Quần vải thô";
                    case 2:
                        return "Găng vải thô";
                    case 3:
                        return "Giầy vải thô";
                }
                break;
        }
        return "";
    }

    //--------------------------------------------------------------------------Text tab combine
    private String getTextTopTabCombine(int type) {
        switch (type) {
            case EP_SAO_TRANG_BI:
                return "Ta sẽ phù phép\ncho trang bị của ngươi\ntrở lên mạnh mẽ";
            case EP_SAO_TRANG_BI_THANG_CAP:
                return "Ta sẽ phù phép\ncho trang bị của ngươi\ntrở lên mạnh mẽ";
            case PHA_LE_HOA_TRANG_BI:
                return "Ta sẽ phù phép\ncho trang bị của ngươi\ntrở thành trang bị pha lê";
            case AN_TRANG_BI:
                return "Ta sẽ phù phép\ncho trang bị của ngươi\ntrở thành trang bị Ấn";
            case NHAP_NGOC_RONG:
                return "Ta sẽ phù phép\ncho 10 viên Ngọc Rồng\nthành 1 viên Ngọc Rồng cấp cao";
            case NANG_CAP_VAT_PHAM:
                return "Ta sẽ phù phép cho trang bị của ngươi trở lên mạnh mẽ";
            case PHAN_RA_DO_THAN_LINH:
                return "Ta sẽ phân rã \n  trang bị của người thành Mây Ngũ Sắc!";
            case NANG_CAP_DO_TS:
                return "Ta sẽ nâng cấp \n  trang bị của người thành\n đồ thiên sứ!";
            case NANG_CAP_SKH_VIP:
                return "Thiên sứ nhờ ta nâng cấp \n  trang bị của người thành\n SKH VIP!";
            case NANG_CAP_BONG_TAI:
                return "Ta sẽ phù phép\ncho bông tai Porata của ngươi\nthành cấp 2";
            case MO_CHI_SO_BONG_TAI:
                return "Ta sẽ phù phép\ncho bông tai Porata cấp 2 của ngươi\ncó 1 chỉ số ngẫu nhiên";
            case MO_CHI_SO_BI_TICH:
                return "Ta sẽ phù phép\ncho bí tịch của ngươi\ncó 1 chỉ số ngẫu nhiên";
            case LUYEN_BI_TICH:
                return "Ta sẽ phù phép\ncho bí tịch của ngươi\ntăng sức mạnh";
            case PS_HOA_TRANG_BI:
                return "Pháp sư hóa trang bị";
            case TAY_PS_HOA_TRANG_BI:
                return "Tẩy pháp sư";
            case NANG_CAP_CAI_TRANG_SSJ:
                return "Ta sẽ phù phép\ncho Cải Trang của ngươi\nthêm sức mạnh";
            case TIEN_HOA_CAI_TRANG_BABY_VEGETA:
                return "Ta sẽ phù phép\nTiến Hóa cải trang của ngươi mạnh hơn";

            case CHE_TAO_TRANG_BI_TS:
                return "Chế tạo\ntrang bị thiên sứ";
            case DOI_SKH_THANH_DNS:
                return "Ta sẽ phân rã \n  trang bị SKH của ngươi thành Đá Ngũ Sắc!";
            case DAP_SET_KICH_HOAT:
                return "Ta sẽ giúp ngươi chuyển hóa\n1 món đồ hủy diệt\nthành 1 món đồ kích hoạt";
            case DAP_SET_KICH_HOAT_HD:
                return "Đưa ta 150 Đá Ngũ Sắc và 1 Trang Bị Hủy Diệt \n Ta sẽ phù phép thành Set Kích Hoạt!";
            case DAP_SET_KICH_HOAT_TS:
                return "Đưa ta 200 Đá Ngũ Sắc và 1 Trang Bị Thiên Sứ \n Ta sẽ phù phép thành Set Kích Hoạt!";
            case TAY_SKH_TRANG_BI:
                return "Đưa ta 1 Trang Bị SKH và 1 Bùa Tẩy Pháp Sư \n Ta sẽ giúp ngươi tẩy Set Kích Hoạt!";
            case NANG_HUY_DIET_LEN_SKH_VIP:
                return "Ta sẽ nâng cấp đồ huỷ diệt của con lên đồ kích hoạt VIP";
            case NANG_CAP_CHAN_MENH:
                return "Ta sẽ giúp ngươi\nnâng cấp Chân Mệnh\ncủa ngươi lên 1 cấp bậc";
            case EP_CHUNG_NHAN_XUAT_SU:
                return "Ta sẽ giúp ngươi\nnâng cấp bông tai\ncủa ngươi lên 1 cấp bậc";
            case MO_CHI_SO_CAI_TRANG:
                return "Anh có muốn mở chỉ số cải trang?";
            case THUC_TINH_DT:
                return "Ta sẽ giúp Thức Tỉnh chỉ số\ncủa ngươi hoặc đệ tử\nGiúp gia tăng chỉ số cao hơn";
            case DOI_DIEM:
                return "Thức Ăn";
            // START_ SÁCH TUYỆT KỸ //
            case GIAM_DINH_SACH:
                return "Ta sẽ phù phép\ngiám định sách đó cho ngươi";
            case TAY_SACH:
                return "Ta sẽ phù phép\ntẩy sách đó cho ngươi";
            case NANG_CAP_SACH_TUYET_KY:
                return "Ta sẽ phù phép\nnâng cấp Sách Tuyệt Kỹ cho ngươi";
            case PHUC_HOI_SACH:
                return "Ta sẽ phù phép\nphục hồi sách cho ngươi";
            case PHAN_RA_SACH:
                return "Ta sẽ phù phép\nphân rã sách cho ngươi";
            default:
                return "";
        }
    }

    private String getTextInfoTabCombine(int type) {
        switch (type) {
            case EP_SAO_TRANG_BI:
                return "Chọn trang bị\n(Áo, quần, găng, giày hoặc rađa) có ô đặt sao pha lê\nChọn loại sao pha lê\n"
                        + "Sau đó chọn 'Nâng cấp'";
            case EP_SAO_TRANG_BI_THANG_CAP:
                return "Chọn trang bị\n(Áo, quần, găng, giày hoặc rađa) có ô đặt sao pha lê\nChọn loại sao pha lê\n"
                        + "Sau đó chọn 'Nâng cấp'";
            case PHA_LE_HOA_TRANG_BI:
                return "Chọn trang bị\n(Áo, quần, găng, giày hoặc rađa)\nSau đó chọn 'Nâng cấp'";
            case NHAP_NGOC_RONG:
                return "Vào hành trang\nChọn 10 viên ngọc cùng sao\nSau đó chọn 'Làm phép'";
            case NANG_CAP_VAT_PHAM:
                return "vào hành trang\nChọn trang bị\n(Áo, quần, găng, giày hoặc rađa)\nChọn loại đá để nâng cấp\n"
                        + "Sau đó chọn 'Nâng cấp'";
            case PHAN_RA_DO_THAN_LINH:
                return "Vào hành trang\nChọn trang bị\n(Áo, quần, găng, giày hoặc nhẫn thần linh)\n"
                        + "Sau đó chọn 'Phân Rã'";
            case NANG_CAP_DO_TS:
                return "vào hành trang\nChọn 2 trang bị hủy diệt bất kì\nkèm 1 món đồ thần linh\n và 999 mảnh thiên sứ\n "
                        + "Sau đó chọn 'Nâng Cấp'";
            case NANG_CAP_SKH_VIP:
                return "vào hành trang\nChọn 1 trang bị thiên sứ bất kì\nChọn tiếp ngẫu nhiên 2 món SKH thường \n "
                        + " đồ SKH VIP sẽ cùng loại \n với đồ thiên sứ!"
                        + "Chỉ cần chọn 'Nâng Cấp'";

            case PS_HOA_TRANG_BI:
                return "vào hành trang\nChọn 1 trang bị có thể hắc hóa ( danh hiệu cao thủ ) và đá pháp sư \n "
                        + " để nâng cấp chỉ số pháp sư"
                        + "Chỉ cần chọn 'Nâng Cấp'";
            case TAY_PS_HOA_TRANG_BI:
                return "vào hành trang\nChọn 1 trang bị có thể hắc hóa ( phụ kiên,ngọc bội,pet,..) và bùa giải pháp sư \n "
                        + " để xoá nâng cấp chỉ số pháp sư"
                        + "Chỉ cần chọn 'Nâng Cấp'";
            case CHE_TAO_TRANG_BI_TS:
                return "Cần 1 công thức vip\nMảnh trang bị tương ứng\n"
                        + "Số Lượng\n999"
                        + "Có thể thêm\nĐá nâng cấp (tùy chọn) để tăng tỉ lệ chế tạo\n"
                        + "Đá may mắn (tùy chọn) để tăng tỉ lệ các chỉ số cơ bản và chỉ số ẩn\n"
                        + "Sau đó chọn 'Nâng cấp'";
            case NANG_CAP_BONG_TAI:
                return "Vào hành trang\nChọn Porata Cấp 1 và 99 mảnh vỡ bông tai\nSau đó chọn 'Nâng cấp'";
            case MO_CHI_SO_BONG_TAI:
                return "Vào hành trang\nChọn Porata Cấp 2 + 99 mảnh hồn bông tai + 1 Đá xanh lam \nSau đó chọn 'Nâng cấp'";
            case MO_CHI_SO_BI_TICH:
                return "Vào hành trang\nChọn Bí Tịch + 300 điểm bí tịch \nSau đó chọn 'Nâng cấp'";
            case LUYEN_BI_TICH:
                return "Vào hành trang\nChọn Bí Tịch + Sách Luyện Bí Tịch \nSau đó chọn 'Luyện Bí Tịch'";
            case DOI_SKH_THANH_DNS:
                return "Cần 1 món sét kích hoạt bất kỳ"
                        + "Sau đó chọn 'Nâng cấp'";
            case DAP_SET_KICH_HOAT:
                return "Vào hành trang\nChọn món đồ hủy diệt tương ứng\n(Áo, quần, găng, giày hoặc nhẫn)\n"
                        + "(Có thể thêm 1 món đồ thần linh bất kỳ để tăng tỉ lệ)\nSau đó chọn 'Đập'";
            case DAP_SET_KICH_HOAT_HD:
                return "Cần 1 Trang Bị Thần Linh bất kỳ và 150 Đá Ngũ Sắc"
                        + "Sau đó chọn 'Nâng cấp'";
            case DAP_SET_KICH_HOAT_TS:
                return "Cần 1 Trang Bị Thần Linh bất kỳ và 200 Đá Ngũ Sắc"
                        + "Sau đó chọn 'Nâng cấp'";

            case TAY_SKH_TRANG_BI:
                return "Cần 1 Trang Bị SKH ( Thần Linh, Hủy Diệt, Thiên Sứ và 1 Bùa Tẩy Pháp Sư"
                        + "\nSau đó chọn 'Tẩy SKH'";
            case KHAC_CHI_SO_DA:
                return "Cần 1 Ngọc Bội - Hoàng Kim và 1 Đá Khắc Chỉ Số"
                        + "\nSau đó chọn 'Điêu Khắc'";
            case KHAC_CHI_SO_NGOC_BOI:
                return "Cần 1 Ngọc Bội - Hoàng Kim và 1 Đá Khắc Chỉ Số"
                        + "\nSau đó chọn 'Điêu Khắc Ngọc Bội'";
            case THANG_CAP_TRANG_BI:
                return "Cần 1 Trang Bị 16 Sao, Đá Bảo Vệ và Lửa Thần"
                        + "\nSau đó chọn 'Thăng Cấp Trang Bị'";
            case AN_TRANG_BI:
                return "Vào hành trang\nChọn 1 Trang bị THIÊN SỨ và 99 mảnh Ấn\nSau đó chọn 'Làm phép'\n--------\nTinh ấn (5 món +30%HP)\n Nhật ấn (5 món +30%KI\n Nguyệt ấn (5 món +20%SD)";
            case NANG_HUY_DIET_LEN_SKH_VIP:
                return "Vào hành trang\n Chọn 3 món huỷ diệt bất kỳ, món đầu tiên sẽ làm gốc, sau đó chọn 'Nâng cấp'";
            case NANG_CAP_CHAN_MENH:
                return "vào hành trang\nChọn Chân Mệnh\nVà 99 Đá Ngũ Sắc "
                        + "Bấm Nâng Cấp";
            case EP_CHUNG_NHAN_XUAT_SU:
                return "vào hành trang\nChọn bông tai cấp 2\nVà 1 giấy chứng nhận xuất sư "
                        + "Bấm Nâng Cấp";
            case MO_CHI_SO_CAI_TRANG:
                return "vào hành trang\nChọn 1 cái trang chưa kích hoạt và 99 đá ngũ sắc"
                        + "Chỉ cần chọn 'Nâng Cấp'";
            case THUC_TINH_DT:
                return "Nguyên liệu cần có:\n\n"
                        + "[Đối với Đệ Tử]\nx15 Đá Thức Tỉnh\nx3 Ngọc Rồng 3 Sao\nx1 Thỏi Vàng\n"
                        + "Khi thức tỉnh sẽ có khả năng Đột Phá\nGiúp tăng thêm 1 cấp bậc đệ tử\n"
                        + "[Đối với Sư Phụ]\nx30 Đá Thức Tỉnh\nx3 Ngọc Rồng 1 Sao\nx3 Thỏi Vàng\n"
                        + "(Nếu thất bại sẽ chì mất đá thức tỉnh)\n\n"
                        + "Sau khi đủ nguyên liệu chọn 'Nâng cấp'";
            case DOI_DIEM:
                return "Vào hành trang\nChọn x99 Thức Ăn\nSau đó chọn 'Nâng cấp'";
            case GIAM_DINH_SACH:
                return "Vào hành trang chọn\n1 sách cần giám định";
            case TAY_SACH:
                return "Vào hành trang chọn\n1 sách cần tẩy";
            case NANG_CAP_SACH_TUYET_KY:
                return "Vào hành trang chọn\nSách Tuyệt Kỹ 1 cần nâng cấp và 10 Kìm bấm giấy";
            case PHUC_HOI_SACH:
                return "Vào hành trang chọn\nCác Sách Tuyệt Kỹ cần phục hồi";
            case PHAN_RA_SACH:
                return "Vào hành trang chọn\n1 sách cần phân rã";
            default:
                return "";
        }
    }

}
