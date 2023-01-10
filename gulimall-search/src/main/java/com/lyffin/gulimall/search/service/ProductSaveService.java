package com.lyffin.gulimall.search.service;

import com.lyffin.gulimall.common.to.es.SkuEsModel;

import java.util.List;

public interface ProductSaveService {
    boolean productStatusUp(List<SkuEsModel> skuEsModels) throws Exception;
}
