package com.example.order.server.util;

import com.example.order.server.ServerApplicationTests;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.*;

@Component
class MD5Test extends ServerApplicationTests {

    @Test
    void digest() {
        String digest = MD5.digest("key", "1");
        Assert.assertTrue(digest.length() == 32);
    }

    @Test
    void verify() {
        Boolean bool = MD5.verify("key", "1", "c2add694bf942dc77b376592d9c862cd");
        Assert.assertTrue(bool == true);
    }
}