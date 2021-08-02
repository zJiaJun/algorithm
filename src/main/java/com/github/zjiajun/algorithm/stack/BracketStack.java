package com.github.zjiajun.algorithm.stack;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhujiajun
 * @version 1.0
 * @since 2021/8/2 15:12
 */
public class BracketStack {


    private static final Map<Character, Character> map = new HashMap<>();

    static {
        map.put('{', '}');
        map.put('(', ')');
        map.put('[', ']');
    }

    public boolean isMatch(String bracket) {
        if (bracket == null || bracket.isEmpty()) {
            return false;
        }
        ArrayStack<Character> arrayStack = new ArrayStack<>(50);
        for (Character c : bracket.toCharArray()) {
            if (map.containsKey(c)) {
                arrayStack.push(c);
            } else {
                Character leftBracket = arrayStack.pop();
                if (leftBracket == null || !map.get(leftBracket).equals(c)) {
                    return false;
                }
            }
        }
        return arrayStack.isEmpty();
    }
}
