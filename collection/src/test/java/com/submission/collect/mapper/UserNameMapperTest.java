package com.submission.collect.mapper;

import cn.hutool.core.util.IdUtil;
import com.submission.collection.entity.name.CollectionName;
import com.submission.collection.mapper.UserNameMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author YangXiao
 * @since 2023/2/5 12:37
 */
@SpringBootTest
class UserNameMapperTest {

    @Autowired
    private UserNameMapper userNameMapper;

    @Test
    void getNameList() {
    }

    @Test
    void insertName() {
//        CollectionName name = new CollectionName();
//        name.setCollectionId("collectionId");
//        name.setUserId("userId");
//        name.setName_("name");
//        String idStr = IdUtil.getSnowflake().nextIdStr();
//        name.setNameId(idStr);
//        userNameMapper.insertName(name);
    }

    @Test
    void insertNameBatch() {
    }
}
