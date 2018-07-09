package cacao;

import org.junit.Test;
import org.thymeleaf.util.StringUtils;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Num3_GE {

    @Test
    public void cacheTest1() {
        assertThat(countTime(0, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}), is(50));
        assertThat(countTime(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}), is(50));


        assertThat(countTime(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}), is(21));
        assertThat(countTime(2, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}), is(60));
        assertThat(countTime(5, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}), is(52));
        assertThat(countTime(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}), is(16));
        assertThat(countTime(0, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}), is(25));

        assertThat(countTime(0, new String[]{"a"}), is(5));
        assertThat(countTime(0, new String[]{"a", "b"}), is(10));
        assertThat(countTime(0, new String[]{"a", "b", "c"}), is(15));

        assertThat(countTime(1, new String[]{"a"}), is(5));
        assertThat(countTime(1, new String[]{"a", "b"}), is(10));
        assertThat(countTime(1, new String[]{"a", "b", "c"}), is(15));

        assertThat(countTime(3, new String[]{"a"}), is(5));
        assertThat(countTime(3, new String[]{"a", "b"}), is(10));
        assertThat(countTime(3, new String[]{"a", "b", "c"}), is(15));

        assertThat(countTime(30, new String[]{"a"}), is(5));
        assertThat(countTime(30, new String[]{"a", "b"}), is(10));
        assertThat(countTime(30, new String[]{"a", "b", "c"}), is(15));


        assertThat(countTime(1, new String[]{"a"}), is(5));
        assertThat(countTime(1, new String[]{"a", "a"}), is(6));
        assertThat(countTime(1, new String[]{"a", "a", "a"}), is(7));

        assertThat(countTime(3, new String[]{"a", "b", "c", "d", "a", "b", "c"}), is(7*5));

        assertThat(countTime(3, new String[]{"a", "b", "c", "a", "b", "c", "a"}), is(3*5+4));

    }

    private int countTime(int cacheSize, String[] cities) {
        CityCache lruCache = new CityCache(cacheSize);
        return lruCache.getTotalSpendTime(cities);
    }
}

class CityCache {
    private static final int IN_CACHE_TIME = 1;
    private static final int IN_DB_TIME = 5;
    private static final int NOT_IN_CACHE = -1;
    private int cacheSize;
    private String[] cache;


    public CityCache(int cacheSize) {
        if(cacheSize < 0 || cacheSize > 30) throw new IllegalArgumentException("캐시 사이즈는 0~30 사이어야 합니다. ");

        this.cacheSize = cacheSize;
        this.cache = new String[cacheSize];
    }

    public int getTotalSpendTime(String[] cities) {
        if(cities.length > 100000) throw new IllegalArgumentException("도시의 수는 100,000 보다 클 수 없습니다.");

        int totalTime = 0;
        for (final String city : cities) {
            // 추상화 수준을 맞춤. 직접적인 로직이 없이 메쏘드 호출만 함.
            int index = getIndexFromCache(city);
            arrangeCacheIndex(index, city);
            totalTime += getAdditionalTime(index);
        }
        return totalTime;
    }

    private int getAdditionalTime(int index) {
        if (index != NOT_IN_CACHE) {
            return IN_CACHE_TIME;
        } else {
            return IN_DB_TIME;
        }
    }

    /**
     * LRU 는 최근 사용한 값이 저장되어 재사용되는 것
     * @param indexOfCache
     * @param city
     */
    private void arrangeCacheIndex(int indexOfCache, String city) {
        if (this.cacheSize < 1) return;

        String[] cacheTmp = new String[this.cacheSize];
        cacheTmp[0] = city.toLowerCase();

        int newCacheIndex = 1;
        for (int i = 0; i < cache.length && newCacheIndex < cache.length; i++) {
            if(indexOfCache == i) continue;
            cacheTmp[newCacheIndex] = cache[i];
            newCacheIndex++;
        }

        cache = cacheTmp;
    }

    private int getIndexFromCache(final String city) {
        for (int i = 0; i < cache.length; i++) {
            if (StringUtils.equals(cache[i], city)) return i;
        }
        return NOT_IN_CACHE;
    }
}