package com.thor.pawPrint.biz.controller.goods;

import com.thor.pawPrint.bean.dto.GoodsDTO;
import com.thor.pawPrint.bean.entity.GoodsDO;
import com.thor.pawPrint.core.common.constant.Constant;
import com.thor.pawPrint.core.common.result.Result;
import com.thor.pawPrint.core.common.result.ResultCode;
import com.thor.pawPrint.core.utils.data.StringUtil;
import com.thor.pawPrint.core.utils.object.ObjectCopyUtil;
import com.thor.pawPrint.core.utils.system.ResultUtil;
import com.thor.pawPrint.dao.daoTemp.GoodsDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * Created by Thor on 2017/2/14.
 * happy coding - 1203!
 */
@Service
@Slf4j
public class GoodsBizImpl implements GoodsBiz {
    @Autowired
    private GoodsDAO goodsDAO;

    @Override
    public Result<List<GoodsDTO>> goodsInSalesTheme(String goodsIds) {
        if (!StringUtil.isValidIdString(goodsIds)) {
            return ResultUtil.errorResult(ResultCode.PARAM_ERROR);
        }

        List<Integer> goodsIdList = StringUtil.stringToIntList(goodsIds);
        List<GoodsDO> goodsDOs = goodsDAO.selectBatchByPrimaryKey(goodsIdList);

        List<GoodsDTO> goodsDTOs = ObjectCopyUtil.copyObjects(goodsDOs, GoodsDTO.class);

        for (GoodsDTO temp : goodsDTOs) {
            temp.setImageArray(getGoodsImageArrayByImageString(temp.getImages()));
        }

        return ResultUtil.successResult(goodsDTOs);
    }

    @Override
    public Result<GoodsDTO> goodsDetail(Integer id) {
        if (ObjectUtils.isEmpty(id)) {
            return ResultUtil.errorResult(ResultCode.PARAM_ERROR);
        }

        GoodsDO goodsDO = goodsDAO.selectByPrimaryKey(id);

        GoodsDTO goodsDTO = ObjectCopyUtil.copyObject(goodsDO, GoodsDTO.class);
        if (!ObjectUtils.isEmpty(goodsDTO)) {
            goodsDTO.setImageArray(getGoodsImageArrayByImageString(goodsDTO.getImages()));
        }

        return ResultUtil.successResult(goodsDTO);
    }

    /*
    根据image字符串获取图片地址数组
     */
    private String[] getGoodsImageArrayByImageString(String imageString) {
        return ObjectUtils.isEmpty(imageString) ? new String[]{Constant.DEFAULT_IMAGE} : imageString.split(Constant.SPLIT_STR_COMMA);
    }

}
