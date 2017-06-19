/**
 * The MIT License
 *
 * Copyright (c) 2013-2017 Jeevanandam M. (myjeeva.com)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.myjeeva.digitalocean.common;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.annotations.SerializedName;

/**
 * Enumeration of protocol used in forwarding rules .
 *
 * @author Thomas Lehoux (https://github.com/tlehoux)
 *
 * @since v2.11
 */
public enum Protocol {

    @SerializedName("http")
    HTTP("http"),

    @SerializedName("https")
    HTTPS("https"),

    @SerializedName("tcp")
    TCP("tcp");

    private String value;

    private Protocol(String value) {
        this.value = value;
    }

    public static Protocol fromValue(String value) {
        if (StringUtils.isBlank(value)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }

        for (Protocol ds : Protocol.values()) {
            if (value.equalsIgnoreCase(ds.value)) {
                return ds;
            }
        }

        throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
    }

    @Override
    public String toString() {
        return this.value;
    }
}
