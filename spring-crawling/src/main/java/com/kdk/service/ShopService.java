package com.kdk.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kdk.dto.CrRequestDto;
import com.kdk.product.ProductTagInfo;
import com.kdk.product.ProducttagInfoRepository;
import com.kdk.util.CrawlerUtil;

@Service
public class ShopService {

  static final Logger logger = LoggerFactory.getLogger(ShopService.class);

  @Autowired
  private ProducttagInfoRepository repository;

  public ProductTagInfo saveProduct(ProductTagInfo productTagInfo) {
    return repository.save(productTagInfo);
  }

  public HashMap<String, Object> crawlingSearch(CrRequestDto req) {
    HashMap<String, Object> result = new LinkedHashMap<>();
    String tType = "";
    String tClassName = "";
    ProductTagInfo target = repository.findByStoreKeyAndTargetType(req.getStoreKey(), req.getType());

    tType = target.getTargetType();
    tClassName = target.getClassName();

    result.put("crawlingData", CrawlerUtil.findByTag(req.getTargetDomain(), tType, tClassName));

    return result;
  }
}
