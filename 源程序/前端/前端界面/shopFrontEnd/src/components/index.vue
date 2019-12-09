<!--首页-->
<template>
  <div>
    <div class="fixeds">
      <img src="static\index\fixed.png" />
    </div>
    <!--头部-->
    <div class="top_t">
      <img src="static/index/top_t.webp" />
    </div>
    <div class="top_m">
      <div class="top_m1"><span style="
                text-decoration:none;"
              @click="goshop">我的购物车</span>
              </div>
      <div class="top_m1">
        <div v-if="ok === true"
             style="float:left;">
          <span @click="backLogin">退出登录</span>
        </div>
      </div>
       <div class="top_m1">
        <div v-if="ok === true"
             style="float:left;">
          <span @click="gobanner">我的订单</span>
        </div>
      </div>
    </div>
    <div class="top_b">
      <TopInput></TopInput>
      <div class="top_b4">
        <img src="static/index/top_b.png.webp" />
      </div>
      <div class="top_b5">
        <ul>
          <li>秒杀</li>
          <li>优惠卷</li>
          <li>plus会员</li>
          <li>品牌闪购</li>
          <li>拍卖</li>
          <li>京东时尚</li>
          <li>京东超市</li>
          <li>京东生鲜</li>
          <li>海囤全球</li>
          <li>京东精融</li>
        </ul>
      </div>
    </div>
    <!--中间-->
    <div class="middle">
      <div class="middle1">
        <div class="middle_t">
          <!--左边导航栏-->
          <div class="middle_left">
            <h3 style=" text-align: center;">全部商品分类</h3>
            <!-- 左边导航栏第1个 -->
            <div class="middle_left1"
                 v-for="x in kindsgoodslist"
                 :key="x.index">
              <span style="color:#000;margin-left:15px;">{{x.main_title}}</span>
              <ul>
                <li>
                  <div class="middle_left1_1">
                    <div>
                      <div class="middle_left1_1_1">家电馆 <i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">家电专卖<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">家电服务 <i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">企业采购<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">商用电器 <i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">以旧换新<i style=" margin-left: 5px;">></i></div>
                    </div>
                    <div class="middle_left1_2_1"
                         v-for="y in x.children"
                         :key="y.index">{{y.type_name2}}<i style=" margin-left: 10px;">></i>
                      <div class="middle_left1_2_2"
                           v-for="z in y.children"
                           :key="z.index">{{z.type_name3}}</div>
                    </div>
                  </div>
                </li>
              </ul>
            </div>
            <!-- 左边导航栏第2个 -->
            <div class="middle_left2"
                 v-for="x in kindsseccondlist"
                 :key="x.index">
              <span style="color:#000;margin-left:15px;">{{x.main_title}}/</span>
              <ul>
                <li>
                  <div class="middle_left2_1">
                    <div>
                      <div class="middle_left1_1_1">玩3C <i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">手机频道<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">营业厅 <i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">配件频道<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">智能数码 <i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">影像club<i style=" margin-left: 5px;">></i></div>
                    </div>
                    <div class="middle_left1_2_1"
                         v-for="y in x.children"
                         :key="y.index">{{y.type_name2}}<i style=" margin-left: 10px;">></i>
                      <div class="middle_left1_2_2"
                           v-for="z in y.children"
                           :key="z.index">{{z.type_name3}}</div>
                    </div>
                  </div>
                </li>
              </ul>
            </div>
            <!-- 左边导航栏第3个 -->
            <div class="middle_left3"
                 v-for="x in kindsthreelist"
                 :key="x.index">
              <span style="color:#000;margin-left:15px;">{{x.main_title}}</span>
              <ul>
                <li>
                  <div class="middle_left3_1">
                    <div>
                      <div class="middle_left1_1_1">玩3C <i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">电脑办公<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">企业采购 <i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">GAME+<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">装机大师 <i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">私人订制<i style=" margin-left: 5px;">></i></div>
                    </div>
                    <div class="middle_left1_2_1"
                         v-for="y in x.children"
                         :key="y.index">{{y.type_name2}}<i style=" margin-left: 10px;">></i>
                      <div class="middle_left1_2_2"
                           v-for="z in y.children"
                           :key="z.index">{{z.type_name3}}</div>
                    </div>
                  </div>
                </li>
              </ul>
            </div>
            <!-- 左边导航栏第4个 -->
            <div class="middle_left4"
                 v-for="x in kindsfourlist"
                 :key="x.index">
              <span style="color:#000;margin-left:15px;">{{x.main_title}}</span>
              <ul>
                <li>
                  <div class="middle_left4_1">
                    <div>
                      <div class="middle_left1_1_1">家装城 <i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">居家日用<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">精品家具 <i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">家装建材<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">国际厨具 <i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">装修服务<i style=" margin-left: 5px;">></i></div>
                    </div>
                    <div class="middle_left1_2_1"
                         v-for="y in x.children"
                         :key="y.index">{{y.type_name2}}<i style=" margin-left: 10px;">></i>
                      <div class="middle_left1_2_2"
                           v-for="z in y.children"
                           :key="z.index">{{z.type_name3}}</div>
                    </div>
                  </div>
                </li>
              </ul>
            </div>
            <!-- 左边导航栏第5个 -->
            <div class="middle_left5"
                 v-for="x in kindsfivelist"
                 :key="x.index">
              <span style="color:#000;margin-left:15px;">{{x.main_title}}</span>
              <ul>
                <li>
                  <div class="middle_left5_1">
                    <div>
                      <div class="middle_left1_1_1">男装<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">女装<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">内衣<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">家装建材<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">童装童鞋 <i style=" margin-left: 5px;">></i></div>
                    </div>
                    <div class="middle_left1_2_1"
                         v-for="y in x.children"
                         :key="y.index">{{y.type_name2}}<i style=" margin-left: 10px;">></i>
                      <div class="middle_left1_2_2"
                           v-for="z in y.children"
                           :key="z.index">{{z.type_name3}}</div>
                    </div>
                  </div>
                </li>
              </ul>
            </div>
            <!-- 左边导航栏第6个 -->
            <div class="middle_left6"
                 v-for="x in kindssexlist"
                 :key="x.index">
              <span style="color:#000;margin-left:15px;">{{x.main_title}}</span>
              <ul>
                <li>
                  <div class="middle_left6_1">
                    <div>
                      <div class="middle_left1_1_1">清洁用品<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">美妆馆<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">个护管<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">妆比社<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">宠物馆 <i style=" margin-left: 5px;">></i></div>
                    </div>
                    <div class="middle_left1_2_1"
                         v-for="y in x.children"
                         :key="y.index">{{y.type_name2}}<i style=" margin-left: 10px;">></i>
                      <div class="middle_left1_2_2"
                           v-for="z in y.children"
                           :key="z.index">{{z.type_name3}}</div>
                    </div>
                  </div>
                </li>
              </ul>
            </div>
            <!-- 左边导航栏第7个 -->
            <div class="middle_left7"
                 v-for="x in kindssenvenlist"
                 :key="x.index">
              <span style="color:#000;margin-left:15px;">{{x.main_title}}</span>
              <ul>
                <li>
                  <div class="middle_left7_1">
                    <div>
                      <div class="middle_left1_1_1">自营鞋靴<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">自营箱包<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">时尚鞋包 <i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">潮流珠宝<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">奢侈品<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">时尚K金<i style=" margin-left: 5px;">></i></div>
                    </div>
                    <div class="middle_left1_2_1"
                         v-for="y in x.children"
                         :key="y.index">{{y.type_name2}}<i style=" margin-left: 10px;">></i>
                      <div class="middle_left1_2_2"
                           v-for="z in y.children"
                           :key="z.index">{{z.type_name3}}</div>
                    </div>
                  </div>
                </li>
              </ul>
            </div>
            <!-- 左边导航栏第8个 -->
            <div class="middle_left8"
                 v-for="x in kindseightlist"
                 :key="x.index">
              <span style="color:#000;margin-left:15px;">{{x.main_title}}</span>
              <ul>
                <li>
                  <div class="middle_left8_1">
                    <div>
                      <div class="middle_left1_1_1">体育服务<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">运动城<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">户外馆 <i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">健身房<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">骑行馆<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">钟表城<i style=" margin-left: 5px;">></i></div>
                    </div>
                    <div class="middle_left1_2_1"
                         v-for="y in x.children"
                         :key="y.index">{{y.type_name2}}<i style=" margin-left: 10px;">></i>
                      <div class="middle_left1_2_2"
                           v-for="z in y.children"
                           :key="z.index">{{z.type_name3}}</div>
                    </div>
                  </div>
                </li>
              </ul>
            </div>
            <!-- 左边导航栏第9个 -->
            <div class="middle_left9"
                 v-for="x in kindsninelist"
                 :key="x.index">
              <span style="color:#000;margin-left:15px;">{{x.main_title}}</span>
              <ul>
                <li>
                  <div class="middle_left9_1">
                    <div>
                      <div class="middle_left1_1_1">全新汽车<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">车管家<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">舰旗店 <i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">二手车<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">直营店<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">油卡充值<i style=" margin-left: 5px;">></i></div>
                    </div>
                    <div class="middle_left1_2_1"
                         v-for="y in x.children"
                         :key="y.index">{{y.type_name2}}<i style=" margin-left: 10px;">></i>
                      <div class="middle_left1_2_2"
                           v-for="z in y.children"
                           :key="z.index">{{z.type_name3}}</div>
                    </div>
                  </div>
                </li>
              </ul>
            </div>
            <!-- 左边导航栏第10个 -->
            <div class="middle_left10"
                 v-for="x in kindstenlist"
                 :key="x.index">
              <span style="color:#000;margin-left:15px;">{{x.main_title}}</span>
              <ul>
                <li>
                  <div class="middle_left10_1">
                    <div>
                      <div class="middle_left1_1_1">母婴<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">玩具乐器<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">奶粉馆 <i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">尿裤馆<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">海囤母婴<i style=" margin-left: 5px;">></i></div>
                    </div>
                    <div class="middle_left1_2_1"
                         v-for="y in x.children"
                         :key="y.index">{{y.type_name2}}<i style=" margin-left: 10px;">></i>
                      <div class="middle_left1_2_2"
                           v-for="z in y.children"
                           :key="z.index">{{z.type_name3}}</div>
                    </div>
                  </div>
                </li>
              </ul>
            </div>
            <!-- 左边导航栏第11个 -->
            <div class="middle_left11"
                 v-for="x in kindselevenlist"
                 :key="x.index">
              <span style="color:#000;margin-left:15px;">{{x.main_title}}</span>
              <ul>
                <li>
                  <div class="middle_left11_1">
                    <div>
                      <div class="middle_left1_1_1">生鲜<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">食品饮料<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">酒类 <i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">地方特产<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">海囤全球美食<i style=" margin-left: 5px;">></i></div>
                    </div>
                    <div class="middle_left1_2_1"
                         v-for="y in x.children"
                         :key="y.index">{{y.type_name2}}<i style=" margin-left: 10px;">></i>
                      <div class="middle_left1_2_2"
                           v-for="z in y.children"
                           :key="z.index">{{z.type_name3}}</div>
                    </div>
                  </div>
                </li>
              </ul>
            </div>
            <!-- 左边导航栏第12个 -->
            <div class="middle_left12"
                 v-for="x in kindstwelvelist"
                 :key="x.index">
              <span style="color:#000;margin-left:15px;">{{x.main_title}}</span>
              <ul>
                <li>
                  <div class="middle_left12_1">
                    <div>
                      <div class="middle_left1_1_1">京猫礼品<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">火机烟具<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">鲜花 <i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">京猫农服<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">同城绿植<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">园林园艺<i style=" margin-left: 5px;">></i></div>
                    </div>
                    <div class="middle_left1_2_1"
                         v-for="y in x.children"
                         :key="y.index">{{y.type_name2}}<i style=" margin-left: 10px;">></i>
                      <div class="middle_left1_2_2"
                           v-for="z in y.children"
                           :key="z.index">{{z.type_name3}}</div>
                    </div>
                  </div>
                </li>
              </ul>
            </div>
            <!-- 左边导航栏第13个 -->
            <div class="middle_left13"
                 v-for="x in kindsthirteenlist"
                 :key="x.index">
              <span style="color:#000;margin-left:15px;">{{x.main_title}}</span>
              <ul>
                <li>
                  <div class="middle_left13_1">
                    <div>
                      <div class="middle_left1_1_1">专科用药<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">滋补养身<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">膳食补充 <i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">健康监测<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">两性情话<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">靓眼视界<i style=" margin-left: 5px;">></i></div>
                    </div>
                    <div class="middle_left1_2_1"
                         v-for="y in x.children"
                         :key="y.index">{{y.type_name2}}<i style=" margin-left: 10px;">></i>
                      <div class="middle_left1_2_2"
                           v-for="z in y.children"
                           :key="z.index">{{z.type_name3}}</div>
                    </div>

                  </div>
                </li>
              </ul>
            </div>
            <!-- 左边导航栏第14个 -->
            <div class="middle_left14"
                 v-for="x in kindsfourteenlist"
                 :key="x.index">
              <span style="color:#000;margin-left:15px;">{{x.main_title}}</span>
              <ul>
                <li>
                  <div class="middle_left14_1">
                    <div>
                      <div class="middle_left1_1_1">图书<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">文娱<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">教育培训 <i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">电子书<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">寄卖商城<i style=" margin-left: 5px;">></i></div>
                    </div>
                    <div class="middle_left1_2_1"
                         v-for="y in x.children"
                         :key="y.index">{{y.type_name2}}<i style=" margin-left: 10px;">></i>
                      <div class="middle_left1_2_2"
                           v-for="z in y.children"
                           :key="z.index">{{z.type_name3}}</div>
                    </div>
                  </div>
                </li>
              </ul>
            </div>
            <!-- 左边导航栏第15个 -->
            <div class="middle_left15"
                 v-for="x in kindsfifteenlist"
                 :key="x.index">
              <span style="color:#000;margin-left:15px;">{{x.main_title}}</span>
              <ul>
                <li>
                  <div class="middle_left15_1">
                    <div>
                      <div class="middle_left1_1_1">本周热荐<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">精选酒店<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">特惠机票 <i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">主题乐园<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">电影票<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">会议团建<i style=" margin-left: 5px;">></i></div>
                    </div>
                    <div class="middle_left1_2_1"
                         v-for="y in x.children"
                         :key="y.index">{{y.type_name2}}<i style=" margin-left: 10px;">></i>
                      <div class="middle_left1_2_2"
                           v-for="z in y.children"
                           :key="z.index">{{z.type_name3}}</div>
                    </div>
                  </div>
                </li>
              </ul>
            </div>
            <!-- 左边导航栏第16个 -->
            <div class="middle_left16"
                 v-for="x in kindssixteenlist"
                 :key="x.index">
              <span style="color:#000;margin-left:15px;">{{x.main_title}}</span>
              <ul>
                <li>
                  <div class="middle_left16_1">
                    <div>
                      <div class="middle_left1_1_1">京猫服务<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">安装服务<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">维修服务 <i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">清洗保养<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">企悦服务<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">特色服务<i style=" margin-left: 5px;">></i></div>
                    </div>
                    <div class="middle_left1_2_1"
                         v-for="y in x.children"
                         :key="y.index">{{y.type_name2}}<i style=" margin-left: 10px;">></i>
                      <div class="middle_left1_2_2"
                           v-for="z in y.children"
                           :key="z.index">{{z.type_name3}}</div>
                    </div>
                  </div>
                </li>
              </ul>
            </div>
            <!-- 左边导航栏第17个 -->
            <div class="middle_left17"
                 v-for="x in kindsseventeenlist"
                 :key="x.index">
              <span style="color:#000;margin-left:15px;">{{x.main_title}}</span>
              <ul>
                <li>
                  <div class="middle_left17_1">
                    <div>
                      <div class="middle_left1_1_1">企业购<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">工业品<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">京猫商用 <i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">礼品卡<i style=" margin-left: 5px;">></i></div>
                      <div class="middle_left1_1_1">元器件<i style=" margin-left: 5px;">></i></div>
                    </div>
                    <div class="middle_left1_2_1"
                         v-for="y in x.children"
                         :key="y.index">{{y.type_name2}}<i style=" margin-left: 10px;">></i>
                      <div class="middle_left1_2_2"
                           v-for="z in y.children"
                           :key="z.index">{{z.type_name3}}</div>
                    </div>
                  </div>
                </li>
              </ul>
            </div>
          </div>
          <!-- 左边导航栏结束 -->
          <div class="middle_middle">
            <div class="middle_m1">
              <template>
                <el-carousel :interval="5000"
                             arrow="always">
                  <el-carousel-item v-for="(item,index) in imggoodslist"
                                    :key="item.index">
                    <img :src="item.imgSrc"
                         style=" height:400px;width:100%;"
                         @click="photoimg(item.keytitle)" />
                  </el-carousel-item>
                </el-carousel>
              </template>
            </div>
            <div style="margin-top:21px;">
              <template>
                <el-carousel :interval="4000"
                             type="card"
                             height="200px">
                  <el-carousel-item v-for="(item,index) in imggoodsfirstlist"
                                    :key="item.index">
                    <img :src="item.imgSrc"
                         style=" width: 100%;"
                         @click="photoimg(item.keytitle)" />
                  </el-carousel-item>
                </el-carousel>
              </template>
            </div>
          </div>
          <div class="middle_right">
            <div style=""
                 v-for="(x,index) in imggoodsseccondlist"
                 :key="x.index">
              <img :src="x.imgSrc"
                   height="136px"
                   @click="photoimg(x.keytitle)" />
            </div>
          </div>
          <div class="middle_right2">
            <div class="boxTop">
              <img src="static/index/2.tu22.png"
                   style="width:30%;float:left;margin-left:10%;margin-top:5%;border-radius:100%;">
              <div class="rightFont">
                <p style="float:left;">hi</p>
                <div v-if="ok === false"
                     style="float:left;">
                  <router-link to="/login"
                               style="text-decoration:none">欢迎京猫</router-link>
                </div>
                <div v-if="ok === false"
                     style="float:left;">
                  <router-link to="/login"
                               style="text-decoration:none">登录</router-link>
                </div>
                <div style="float:left;"
                     v-else-if="ok === true">{{loginUserName}}</div>
                <div v-if="ok === false"
                     style="float:left;">
                  <router-link to="/zhuce"
                               style="text-decoration:none"> &nbsp | 注册</router-link>
                </div>
              </div>
              <div class="bottom_middle">
                <a href=""
                   style="display: inline-block;text-decoration:none;line-height: 25px; width:55px;height:25px;font-size: 12px;
                      text-align: center;color: #fff;border-radius: 13px;background: #e1251b;">新人福利</a>
                <a href=""
                   style="display: inline-block;text-decoration:none;margin: 0 5px;width:55px; height:25px;line-height: 25px;
                      font-size: 12px;text-align: center;color: #e5d790;border-radius: 13px;background: #673937;">PLUS会员</a>
              </div>
            </div>
            <div class="boxMiddle">
              <h5 style="float:left;margin-left:7%;">京猫快报</h5>
              <a href=""
                 style="font-size:12px;float:right;margin-right:8%;text-decoration:none">更多
                <i class="el-icon-arrow-right"></i>
              </a>
            </div>
            <div class="boxLast"
                 v-for="x in rightlist"
                 :key="x.index">
              <div class="fontRed">{{x.rigthtitle}}</div>
              <div class="fontRedButtom">{{x.righttitle1}}</div>
            </div>
            <div class="boxButtom">
              <div class="buttomImg"
                   v-for="(x,index) in imgTitlegoodsseccondlist"
                   :key="x.index">
                <img :src="x.imgSrc"
                     width="40px">
                <div class="buttomFont">{{x.title}}</div>
              </div>
            </div>
          </div>
        </div>
        <!--第二部分 -->
      </div>
      <!--第二个-->
      <div class="middle_m3">
        <div class="middle_box">
          <div class="middle_m3_1"
               v-for="(x,id) in imggoodsfourlist"
               :key="x.id">
            <img :src="x.imgSrc"
                 style="width:100%;"
                 @click="photoimg(x.keytitle)" />
          </div>
          <div class="middle_m3_2"
               v-for="(x,index) in imggoodsthirdlist"
               :key="x.index">
            <img :src="x.imgSrc"
                 width="99%"
                 @click="photoimg(x.keytitle)" />
          </div>
        </div>
      </div>
      <!--第六个-->
      <div class="grid_c1">
        <div class="centerImg9">
          <h3 style="float:left;margin-top:20px;margin-left:5%;">逛好店</h3>
          <div class="boxStore"
               @click="book('书')">
            <div class="fontBooks">人民教育出版社</div>
            <div class="books"><img src="static/index/4.tu48.webp"
                   width="60%"></div>
            <span style="font-size:12px;color:red;float:left;margin-left:8%;
            border: red solid 1px;">自营</span>
            <span style="font-size:12px;color:#7699c4;float:left;margin-left:8%;
             border: #7699c4 solid 1px;">博览群书</span>
            <span style="font-size:12px;color:#d0c3c7;float:left;margin-left:8%;margin-top:10%;">4.5万人关注</span>
          </div>
          <div class="boxStore1"
               @click="book('锅')">
            <div class="fontBooks">圆迈只能旗舰店</div>
            <div class="books"><img src="static/index/4.tu50.webp"
                   width="90%"></div>
            <span style="font-size:12px;color:#7699c4;float:left;margin-left:8%;
             border: #7699c4 solid 1px;">家电集结</span>
            <span style="font-size:12px;color:#d0c3c7;float:left;margin-left:8%;margin-top:10%;">58.6万人关注</span>
          </div>
        </div>
        <div class="centerImg9">
          <div class="fontWeb">发现好货</div>
          <div class="carousel">
            <el-carousel :interval="5000"
                         arrow="always">
              <el-carousel-item v-for="(item,index) in imgTitlegoodslist"
                                :key="item.index"
                                style="wdith:100px">
                <div class="item"> <img :src="item.imgSrc"
                       width="100%"
                       @click="toImgSrc(item.keytitle)"></div>
                <div style="font-size:14px;color: #7699c4;margin-left:60px;">{{item.title}}</div>
              </el-carousel-item>
            </el-carousel>
          </div>
        </div>
        <div class="centerImg9">
          <h3 style="float:left;margin-top:20px;margin-left:5%;">新品首发</h3>
          <div class="boxStore2"
               @click="book('空调')">
            <div class="fontBooks">戴森（DYSON）<br />
              空气净化空气</div>
            <div class="books1"><img src="static/index/4.tu51.webp"
                   width="90%"></div>
            <span style="font-size:12px;color:red;float:left;margin-left:8%;
             border: red solid 1px;">人气新品</span>
            <span style="font-size:12px;color:#d0c3c7;float:left;margin-left:8%;margin-top:15%;">4.5万人关注</span>
          </div>
          <img src="static/index/4.tu52.webp"
               style="width:30%;float:left;margin-left:3%;margin-top:3%"
               @click="book('电脑')">
          <img src="static/index/4.tu53.webp"
               style="width:30%;float:left;margin-left:3%;margin-top:3%"
               @click="book('手机')">
          <img src="static/index/4.tu54.webp"
               style="width:30%;float:left;margin-left:3%;margin-top:3%"
               @click="book('耳机')">
        </div>
        <div class="centerImg9">
          <div class="fontWeb">发现</div>
          <div class="carousel">
            <el-carousel :interval="5000"
                         arrow="always">
              <el-carousel-item v-for="(item,index) in imgTitlegoodsfirstlist"
                                :key="item.index">
                <div class="item"> <img :src="item.imgSrc"
                       width="100%"
                       @click="toImgSrc(item.keytitle)"></div>
                <div style="font-size:14px;color: #7699c4;margin-left:60px;">{{item.title}}</div>
                <div></div>
              </el-carousel-item>
            </el-carousel>
          </div>
        </div>
        <div style=" text-align: center;">
          <h1>频道广场</h1>
        </div>
        <img src="static/index/2.tu20.png"
             width="290px"
             height="410px"
             style="float:left;margin-top:10px;" />
        <img src="static/index/2.tu21.png"
             width="290px"
             height="410px"
             style="float:left;margin-left:7px;margin-top:10px;margin-right:7px;" />
        <div class="centerImg5"
             v-for="x in middlelist"
             :key="x.index"
             @click="list(x.keyword)">
          <div class="tuImg">
            <h3 style="float:left;">{{x.middletitle}}</h3>
            <sub style="color:#999">{{x.middletitle1}}</sub>
          </div>
          <div class="tuImg1">
            <img :src="x.middleimg"
                 width="120px;"
                 height="100px;" />
          </div>
          <div class="tuImg2">
            <img :src="x.middleimg1"
                 width="120px;"
                 height="100px;" />
          </div>
        </div>
        <!-- 为您推荐 -->
        <div style=" text-align: center;margin-top:75%">
          <h1>为您推荐</h1>
        </div>
        <el-tabs v-model="activeName"
                 @tab-click="handleClick"
                 style="text-align:center;">
          <el-tab-pane label="精选"
                       name="first"
                       style=" background-color: #f00;">
            <template v-for=" v in selectlist">
              <div class="box_bot"
                   :key="v.id">
                <div class="box_botImg1">
                  <img :src="v.imageSrc"
                       width="160"
                       @click="Jump(v)" />
                </div>
                <div class="font">{{v.title}}</div>
                <div class="fontMoney">￥{{v.price}}</div>
              </div>
            </template>
          </el-tab-pane>
          <el-tab-pane label="家用电器"
                       name="second">
            <template v-for=" v in familylist">
              <div class="box_bot"
                   :key="v.id">
                <div class="box_botImg1">
                  <img :src="v.imageSrc"
                       width="160"
                       @click="Jump(v)" />
                </div>
                <div class="font">{{v.title}}</div>
                <div class="fontMoney">￥{{v.price}}</div>
              </div>
            </template>
          </el-tab-pane>
          <el-tab-pane label="母婴专区"
                       name="third">
            <template v-for=" v in childrenlist">
              <div class="box_bot"
                   :key="v.id">
                <div class="box_botImg1">
                  <img :src="v.imageSrc"
                       width="160"
                       @click="Jump(v)" />
                </div>
                <div class="font">{{v.title}}</div>
                <div class="fontMoney">￥{{v.price}}</div>
              </div>
            </template>
          </el-tab-pane>
          <el-tab-pane label="新款手机"
                       name="fourth">
            <template v-for=" v in phonelist">
              <div class="box_bot"
                   :key="v.id">
                <div class="box_botImg1">
                  <img :src="v.imageSrc"
                       width="160"
                       @click="Jump(v)" />
                </div>
                <div class="font">{{v.title}}</div>
                <div class="fontMoney">￥{{v.price}}</div>
              </div>
            </template>
          </el-tab-pane>
          <el-tab-pane label="新品服装"
                       name="five">
            <template v-for=" v in clotheslist">
              <div class="box_bot"
                   :key="v.id">
                <div class="box_botImg1">
                  <img :src="v.imageSrc"
                       width="160"
                       @click="Jump(v)" />
                </div>
                <div class="font">{{v.title}}</div>
                <div class="fontMoney">￥{{v.price}}</div>
              </div>
            </template>
          </el-tab-pane>
        </el-tabs>
      </div>
    </div>
    <!--尾部-->
    <Bottom></Bottom>
  </div>
</template>
<script>
import '../style/index.css'
import TopInput from './search.vue'
import Bottom from './Bottom.vue'
export default {
  components: { TopInput, Bottom },
  data () {
    return {
      name: sessionStorage.getItem("userName"),
      activeName: 'first',
      toselcetgoods: this.$store.state.url + 'GoodsController/Goods',//查询商品接口
      kindsgoods: this.$store.state.url + 'TypeController/select',
      imgkindsgoods: this.$store.state.url + 'imageController/select',
      toGoods: this.$store.state.url + 'GoodsController/selectGoods',
      imgTitlegoods: this.$store.state.url + 'ImagetitleController/select',
      tokindsgoods: {
        main_title: "家用电器",
      },
      tokidnsseccond: {
        main_title: "手机/运营商/数码",
      },
      tokindsthree: {
        main_title: "电脑/办公",
      },
      tokindsfour: {
        main_title: "家居/家具/家装/厨具",
      },
      tokindsfive: {
        main_title: "男装/女装/童装/内衣",
      },
      tokindssex: {
        main_title: "美妆/个护清洁/宠物",
      },
      tokindsseven: {
        main_title: "女鞋/箱包/钟表/珠宝",
      },
      tokindseight: {
        main_title: "男鞋/运动/户外",
      },
      tokindsnine: {
        main_title: "房产/汽车/汽车用品",
      },
      tokindsten: {
        main_title: "母婴/玩具乐器",
      },
      tokindseleven: {
        main_title: "食品/酒类/生鲜/特产",
      },
      tokindstwelve: {
        main_title: "艺术/礼品鲜花/农资绿植",
      },
      tokindsthirteen: {
        main_title: "医药保健/计生情趣",
      },
      tokindsfourteen: {
        main_title: "图书/文娱/教育/电子书",
      },
      tokindsfifteen: {
        main_title: "机票/酒店/旅游/生活",
      },
      tokindssixteen: {
        main_title: "安装/维修/清洗/二手",
      },
      tokindsseventeen: {
        main_title: "工业品",
      },
      toimggoods: {
        keytitle: "",
        end: 6,
        start: 0
      },//轮播图
      toimggoodsfirst: {
        end: 6,
        start: 6
      },//小轮播
      toimggoodsseccond: {
        end: 4,
        start: 12
      },//轮播右侧
      toimggodsthird: {
        end: 4,
        start: 16
      },//下排序
      toimggoodsfour: {
        end: 10,
        start: 20
      },//上排序
      toimgTitlegoods: {
        end: 3,
        start: 0
      },
      toimgTitlegoodsfirst: {
        end: 3,
        start: 3
      },
      toimgTitlegoodsseccond: {
        end: 19,
        start: 6
      },
      totitle: {
        title: ""
      },
      toselect: {
        pageNo: 8,
        pageNum: 20
      },
      tofamily: {
        pageNo: 30,
        pageNum: 20
      },
      tochildren: {
        pageNo: 110,
        pageNum: 20
      },
      tophone: {
        pageNo: 150,
        pageNum: 20
      },
      toclothes: {
        pageNo: 190,
        pageNum: 20
      },
      imggoodslist: {},//轮播上图
      imggoodsfirstlist: {},//轮播下图
      imggoodsseccondlist: {},//轮播图右侧
      imggoodsthirdlist: {},//下排序
      imggoodsfourlist: {},//上排序
      imgTitlegoodslist: {},//小轮播
      imgTitlegoodsfirstlist: {},//小轮播
      imgTitlegoodsseccondlist: {},//图片加字
      kindsgoodslist: {},//左边导航栏
      kindsseccondlist: {},//左边导航栏第二个
      kindsthreelist: {},//左边导航栏第三个
      kindsfourlist: {},//左边导航栏第四个
      kindsfivelist: {},//左边导航栏第五个
      kindssexlist: {},//左边导航栏第六个
      kindssenvenlist: {},//左边导航栏第七个
      kindseightlist: {},//左边导航栏第八个
      kindsninelist: {},//左边导航栏第九个
      kindstenlist: {},//左边导航栏第十个
      kindselevenlist: {},//左边导航栏第十一个
      kindstwelvelist: {},//左边导航栏第十二个
      kindsthirteenlist: {},//左边导航栏第十三个
      kindsfourteenlist: {},//左边导航栏第十四个
      kindsfifteenlist: {},//左边导航栏第十五个
      kindssixteenlist: {},//左边导航栏第十六个
      kindsseventeenlist: {},//左边导航栏第十七个
      goodslist: {},//搜索的商品信息
      selectlist: {},
      familylist: {},//家电
      childrenlist: {},//母婴专区
      phonelist: {},//新款手机
      clotheslist: {},//新品服装
      homelist: {},//家装城
      booklist: {},//发现好货
      imglist: {},//发现好货
      photoimglist: {},//图片搜索
      phone: "",//登录手机号
      loginUserName: "",//登录用户名
      address: "",//收货地址
      ok: false,
      rightlist: [
        { rigthtitle: "热评", righttitle1: "英伟达RTX 3080显..." },
        { rigthtitle: "热评", righttitle1: "感谢AMD! i9 9900..." },
        { rigthtitle: "最新", righttitle1: "15万的预算，下面4..." },
        { rigthtitle: "热议", righttitle1: "9小时破亿 小米千..." },
      ],
      middlelist: [
        { middletitle: "家装城", middletitle1: "用心装好家一站式购齐", middleimg: "static/index/4.tu1.webp", middleimg1: "static/index/4.tu2.webp", keyword: "电器" },
        { middletitle: "京猫娱乐", middletitle1: "会游戏 懂生活", middleimg: "static/index/4.tu3.webp", middleimg1: "static/index/4.tu4.webp", keyword: "游戏机" },
        { middletitle: "生鲜馆", middletitle1: "尝遍天下", middleimg: "static/index/4.tu5.webp", middleimg1: "static/index/4.tu6.webp", keyword: "生鲜" },
        { middletitle: "拍拍二手", middletitle1: "打牌一元抢", middleimg: "static/index/4.tu7.webp", middleimg1: "static/index/4.tu8.webp", keyword: "二手" },
        { middletitle: "企业购", middletitle1: "让采购更简单", middleimg: "static/index/4.tu9.webp", middleimg1: "static/index/4.tu10.webp", keyword: "木糖醇" },
        { middletitle: "京猫直播", middletitle1: "京猫直播 边看边买", middleimg: "static/index/4.tu11.webp", middleimg1: "static/index/4.tu12.webp", keyword: "玉佩" },
        { middletitle: "海囤全球", middletitle1: "京猫旗下全球直购平台", middleimg: "static/index/4.tu13.webp", middleimg1: "static/index/4.tu14.webp", keyword: "保健品" },
        { middletitle: "个人清洁馆", middletitle1: "欢洗四季 洁净生活", middleimg: "static/index/4.tu15.webp", middleimg1: "static/index/4.tu16.webp", keyword: "肥皂" },
        { middletitle: "Joy寻宝", middletitle1: "懂你的Joy", middleimg: "static/index/4.tu17.webp", middleimg1: "static/index/4.tu18.webp", keyword: "纸巾" },
        { middletitle: "汽车生活", middletitle1: "放心养车 爱车无忧", middleimg: "static/index/4.tu19.webp", middleimg1: "static/index/4.tu20.webp", keyword: "车用品" },
        { middletitle: "日常用品", middletitle1: "京东自有品牌", middleimg: "static/index/4.tu21.webp", middleimg1: "static/index/4.tu22.webp", keyword: "生活" },
        { middletitle: "京猫图书", middletitle1: "遇见恰好的书", middleimg: "static/index/4.tu23.webp", middleimg1: "static/index/4.tu24.webp", keyword: "书" },
      ]
    };
  },

  methods: {
    backLogin () {
      localStorage.clear();
      this.$router.push({
        path: '/login',
        name: 'login',
      })
    },
    gobanner(){
      localStorage.setItem('phone', this.phone),
      localStorage.setItem('address', this.address),
      console.log(this.phone+this.address)
      this.$router.push({
          path: '/banner',
          name: 'banner',
        })
    },
    goshop () {
      if (this.phone === undefined) {
        this.$message({
          message: '您还没有登录，请先登录',
          type: 'error'
        });
        this.$router.push({
          path: '/login',
          name: 'login',
        })
      } else {
        localStorage.setItem('phone', this.phone),
          localStorage.setItem('address', this.address),
          this.$router.push({
            path: '/car',
            name: 'car',
          })
      }
    },
    list (val) {
      this.$axios.post(this.toGoods, { title: val }).then(res => {
        var homelist = res.data.data;
        if (res.data.code == 0) {
          this.homelist = homelist;
          localStorage.setItem('homeList', JSON.stringify(this.homelist)),
            localStorage.setItem('phone', this.phone),
            localStorage.setItem('address', this.address),
            this.$router.push({
              path: '/kinds',
              name: 'kinds',

            })
        } else {
          this.$message({
            message: "本商城没有该类商品",
            type: "error"
          });
        }
      });
    },
    book (val) {
      this.$axios.post(this.toGoods, { title: val }).then(res => {
        var booklist = res.data.data;
        if (res.data.code == 0) {
          this.booklist = booklist;
          localStorage.setItem('bookList', JSON.stringify(this.booklist)),
            localStorage.setItem('phone', this.phone),
            localStorage.setItem('address', this.address),
            this.$router.push({
              path: '/kindsof',
              name: 'kindsof',
            })
        } else {
          this.$message({
            message: "本商城没有该类商品",
            type: "error"
          });
        }
      });
    },
    toImgSrc (val) {
      this.$axios.post(this.toGoods, { title: val }).then(res => {
        var imglist = res.data.data;
        if (res.data.code == 0) {
          this.imglist = imglist;
          localStorage.setItem('imgList', JSON.stringify(this.imglist)),
            localStorage.setItem('phone', this.phone),
            localStorage.setItem('address', this.address),
            this.$router.push({
              path: '/kindsImg',
            })
        } else {
          this.$message({
            message: "本商城没有该类商品",
            type: "error"
          });
        }
      });
    },
    photoimg (val) {
      this.$axios.post(this.toGoods, { title: val }).then(res => {
        var photoimglist = res.data.data;
        if (res.data.code == 0) {
          this.photoimglist = photoimglist;
          localStorage.setItem('photoimgList', JSON.stringify(this.photoimglist)),
            localStorage.setItem('phone', this.phone),
            localStorage.setItem('address', this.address),
            this.$router.push({
              path: '/test',
              name: 'test',
            })
        } else {
          this.$message({
            message: "本商城没有该类商品",
            type: "error"
          });
        }
      });
    },
    handleClick (tab, event) { },
    //选择商品
    selcetgoods (val, count) {
      this.$axios.post(this.toselcetgoods, val).then(res => {
        var selectlist = res.data.data;
        if (count == 1) {
          this.selectlist = selectlist;
        } if (count == 2) {
          this.familylist = selectlist;
        } if (count == 3) {
          this.childrenlist = selectlist;
        } if (count == 4) {
          this.phonelist = selectlist;
        } if (count == 5) {
          this.clotheslist = selectlist;
        }
      });
    },
    //左边导航栏
    kindsleft (val, count) {
      this.$axios.post(this.kindsgoods, val).then(res => {
        if (0 == res.data.code) {
          var kindsgoodslist = res.data.data;
          if (count == 1) {
            this.kindsgoodslist = kindsgoodslist;
          } if (count == 2) {
            this.kindsseccondlist = kindsgoodslist;
          } if (count == 3) {
            this.kindsthreelist = kindsgoodslist;
          } if (count == 4) {
            this.kindsfourlist = kindsgoodslist;
          } if (count == 5) {
            this.kindsfivelist = kindsgoodslist;
          } if (count == 6) {
            this.kindssexlist = kindsgoodslist;
          } if (count == 7) {
            this.kindssenvenlist = kindsgoodslist;
          } if (count == 8) {
            this.kindseightlist = kindsgoodslist;
          } if (count == 9) {
            this.kindsninelist = kindsgoodslist;
          } if (count == 10) {
            this.kindstenlist = kindsgoodslist;
          } if (count == 11) {
            this.kindselevenlist = kindsgoodslist;
          } if (count == 12) {
            this.kindstwelvelist = kindsgoodslist;
          } if (count == 13) {
            this.kindsthirteenlist = kindsgoodslist;
          } if (count == 14) {
            this.kindsfourteenlist = kindsgoodslist;
          } if (count == 15) {
            this.kindsfifteenlist = kindsgoodslist;
          } if (count == 16) {
            this.kindssixteenlist = kindsgoodslist;
          } if (count == 17) {
            this.kindsseventeenlist = kindsgoodslist;
          }
        }
      })
    },
    //轮播图
    imggoods (val, count) {
      this.$axios.post(this.imgkindsgoods, val).then(res => {
        var imggoodslist = res.data.data;
        if (count == 1) {
          this.imggoodslist = imggoodslist;
        } if (count == 2) {
          this.imggoodsfirstlist = imggoodslist;
        } if (count == 3) {
          this.imggoodsseccondlist = imggoodslist;
        } if (count == 4) {
          this.imggoodsthirdlist = imggoodslist;
        } if (count == 5) {
          this.imggoodsfourlist = imggoodslist;
        }
      });
    },
    //图片加字
    imgTitle (val, count) {
      this.$axios.post(this.imgTitlegoods, val).then(res => {
        var imgTitlegoodslist = res.data.data;
        if (count == 1) {
          this.imgTitlegoodslist = imgTitlegoodslist;
        } if (count == 2) {
          this.imgTitlegoodsfirstlist = imgTitlegoodslist;
        } if (count == 3) {
          this.imgTitlegoodsseccondlist = imgTitlegoodslist;
        }
      });
    },
    //跳转传值
    Jump (val) {
      localStorage.setItem('Jumptitle', val.title),
        localStorage.setItem('Jumpprice', val.price),
        localStorage.setItem('JumpimageSrc', val.imageSrc),
        localStorage.setItem('JumpgoodsId', val.goodsId),
        localStorage.setItem('loginUserName', this.loginUserName),
        localStorage.setItem('phone', this.phone),
        localStorage.setItem('address', this.address),
        this.$router.push({
          path: '/goods',
          name: 'goods',
        })
    },
    //传值
    getParams () {
      // 取到路由带过来的参数
      var phone = this.$route.query.loginphone;
      var loginUserName = this.$route.query.loginUserName;
      var address = this.$route.query.address;
      // 将数据放在当前组件的数据内
      this.phone = phone;
      this.loginUserName = loginUserName;
      this.address = address;
    },
  },
  watch: {
    // 监测路由变化,只要变化了就调用获取路由参数方法将数据存储本组件即可
    $route: "getParams"
  },
  mounted () {
    this.imggoods(this.toimggoods, 1);//轮播上图
    this.imggoods(this.toimggoodsfirst, 2);//轮播下图
    this.imggoods(this.toimggoodsseccond, 3)//轮播右侧
    this.imggoods(this.toimggodsthird, 4)//下排序
    this.imggoods(this.toimggoodsfour, 5)//上排序
    this.imgTitle(this.toimgTitlegoods, 1)//小轮播
    this.imgTitle(this.toimgTitlegoodsfirst, 2)//小轮播
    this.imgTitle(this.toimgTitlegoodsseccond, 3)//话费....
    this.kindsleft(this.tokindsgoods, 1);//左边导航栏
    this.kindsleft(this.tokidnsseccond, 2);//左边第二个导航栏
    this.kindsleft(this.tokindsthree, 3)//左边导航栏第三个
    this.kindsleft(this.tokindsfour, 4)//左边导航栏第四个
    this.kindsleft(this.tokindsfive, 5)//左边导航栏第五个
    this.kindsleft(this.tokindssex, 6)//左边导航栏第六个
    this.kindsleft(this.tokindsseven, 7)//左边导航栏第七个
    this.kindsleft(this.tokindseight, 8)//左边导航栏第八个
    this.kindsleft(this.tokindsnine, 9)//左边导航栏第九个
    this.kindsleft(this.tokindsten, 10)//左边导航栏第十个
    this.kindsleft(this.tokindseleven, 11)//左边导航栏第十一个
    this.kindsleft(this.tokindstwelve, 12)//左边导航栏第十二个
    this.kindsleft(this.tokindsthirteen, 13)//左边导航栏第十三个
    this.kindsleft(this.tokindsfourteen, 14)//左边导航栏第十四个
    this.kindsleft(this.tokindsfifteen, 15)//左边导航栏第十五个
    this.kindsleft(this.tokindssixteen, 16)//左边导航栏第十六个
    this.kindsleft(this.tokindsseventeen, 17)//左边导航栏第十七个
    this.selcetgoods(this.toselect, 1);
    this.selcetgoods(this.tofamily, 2);//家用电器
    this.selcetgoods(this.tochildren, 3);//母婴专区
    this.selcetgoods(this.tophone, 4);//新款手机
    this.selcetgoods(this.toclothes, 5);//新品服装
    this.getParams();
    if (this.loginUserName != null) {
      this.$message({
        message: this.loginUserName + "贵宾,欢迎回来,接下来开始购物之旅",
        type: "success"
      });
      this.ok = true;
    }
  }
};
</script>

