package com.submission.collection.service.impl;

import com.submission.collection.service.CollectionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author YangXiao
 * @since 2023/4/23 21:48
 */
@SpringBootTest
class CollectionServiceImplTest {

    @Autowired
    private CollectionService collectionService;

    @Test
    void getDetailCollection() {

        collectionService.getDetailCollection("1650408063979393025");
    }
}
