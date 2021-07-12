package com.kdk.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducttagInfoRepository extends JpaRepository<ProductTagInfo, Long> {

  ProductTagInfo findByStoreKeyAndTargetType(String storeKey, String targetType);

}
