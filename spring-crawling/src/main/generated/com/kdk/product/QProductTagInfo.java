package com.kdk.product;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QProductTagInfo is a Querydsl query type for ProductTagInfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProductTagInfo extends EntityPathBase<ProductTagInfo> {

    private static final long serialVersionUID = 342872641L;

    public static final QProductTagInfo productTagInfo = new QProductTagInfo("productTagInfo");

    public final StringPath className = createString("className");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath storeKey = createString("storeKey");

    public final StringPath targetType = createString("targetType");

    public QProductTagInfo(String variable) {
        super(ProductTagInfo.class, forVariable(variable));
    }

    public QProductTagInfo(Path<? extends ProductTagInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProductTagInfo(PathMetadata metadata) {
        super(ProductTagInfo.class, metadata);
    }

}

