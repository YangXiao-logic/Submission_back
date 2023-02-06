package com.submission.collect.mapper;

import cn.hutool.core.util.IdUtil;
import com.submission.collection.entity.name.Name;
import com.submission.collection.mapper.NameMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author YangXiao
 * @since 2023/2/5 12:37
 */
@SpringBootTest
class NameMapperTest {

    @Autowired
    private NameMapper nameMapper;

    @Test
    void getNameList() {
    }

    @Test
    void insertName() {
        Name name = new Name();
        name.setCollectionId("collectionId");
        name.setUserId("userId");
        name.setName_("name");
        String idStr = IdUtil.getSnowflake().nextIdStr();
        name.setNameId(idStr);
        nameMapper.insertName(name);
    }

    @Test
    void insertNameBatch() {
    }
}
