package com.alibaba.easyretry.common.util;

import java.util.Collections;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RetryUtilsTest {

  @Test
  @DisplayName("test str is not empty")
  void test() {
    Assertions.assertFalse(RetryUtils.isNotEmpty(null));
    Assertions.assertTrue(RetryUtils.isNotEmpty("123"));
    Assertions.assertFalse(RetryUtils.isNotEmpty(""));
  }

  @Test
  @DisplayName("test map is not empty")
  void test2() {
    Assertions.assertFalse(RetryUtils.mapIsNotEmpty(null));
    Assertions.assertFalse(RetryUtils.mapIsNotEmpty(Collections.emptyMap()));
    Assertions.assertTrue(RetryUtils.mapIsNotEmpty(Collections.singletonMap("1", "2")));
  }

  @Test
  @DisplayName("test collection is not empty")
  void test3() {
    Assertions.assertFalse(RetryUtils.collectionIsNotEmpty(null));
    Assertions.assertFalse(RetryUtils.collectionIsNotEmpty(Collections.emptyList()));
    Assertions.assertTrue(RetryUtils.collectionIsNotEmpty(Collections.singletonList("1")));
  }
}
