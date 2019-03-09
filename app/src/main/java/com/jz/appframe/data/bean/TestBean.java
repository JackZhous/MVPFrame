package com.jz.appframe.data.bean;

import java.util.List;

/**
 * @author jackzhous
 * @package com.jz.appframe.data.bean
 * @filename TestBean
 * date on 2019/3/8 6:21 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public class TestBean {

        private int ret;
        private List<Data> data;

        public void setRet(int ret) {
            this.ret = ret;
        }
        public int getRet() {
            return ret;
        }

        public void setData(List<Data> data) {
            this.data = data;
        }
        public List<Data> getData() {
            return data;
        }


}
