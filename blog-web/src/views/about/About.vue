<template>
  <div class="m-container-small m-padded-tb-big" style="padding-top: 120px!important; padding-bottom: 120px!important;">
    <div class="ui container">
      <div class="ui stackable grid">
        <div class="eleven wide column">
          <div class="ui segment m-dialog-shadow">
            <el-carousel direction="vertical" :autoplay="false">
              <el-carousel-item v-for="(item, index) in imgList" :key="index" v-loading="loading">
                <el-image :src="item"></el-image>
              </el-carousel-item>
            </el-carousel>
          </div>
        </div>
        <div class="five wide column">
          <div class=" m-dialog-shadow">
            <div class="ui top attached segment m-navbar">
              <div class="ui header">关于我</div>
            </div>
            <div class="ui teal attached segment">
              <p class="m-text">一个Java初学者</p>
              <p class="m-text">一个编程爱好者</p>
              <p class="m-text">正在学习和探索编写高效代码的方法</p>
            </div>
            <div class="ui attached segment">
              <div class="ui orange basic left pointing label m-margin-tb-tiny">编程</div>
              <div class="ui orange basic left pointing label m-margin-tb-tiny">计算机</div>
              <div class="ui orange basic left pointing label m-margin-tb-tiny">看书</div>
            </div>
            <div class="ui attached segment">
              <div class="ui teal basic left pointing label m-margin-tb-tiny">HTML</div>
              <div class="ui teal basic left pointing label m-margin-tb-tiny">CSS</div>
              <div class="ui teal basic left pointing label m-margin-tb-tiny">Java</div>
              <div class="ui teal basic left pointing label m-margin-tb-tiny">MySQL</div>
            </div>
            <div class="ui bottom attached segment">
              <a href="https://github.com/FromSouthToNorth" class="ui circular icon button violet">
                <i class="github icon"></i>
              </a>
              <el-dropdown trigger="click">
                <span class="el-dropdown-link">
                  <a href="#" class="ui wechat circular icon button teal">
                    <i class="wechat icon"></i>
                  </a>
                </span>
                <el-dropdown-menu slot="dropdown">
                  <el-image :src="src" style="width: 100px; height: 100px;"></el-image>
                </el-dropdown-menu>
              </el-dropdown>
              <el-dropdown trigger="click">
                <span class="el-dropdown-link">
                  <a href="#" class="ui qq circular icon button blue" data-content="598050554" data-position="bottom left">
                    <i class="qq icon"></i>
                  </a>
                </span>
                <el-dropdown-menu slot="dropdown">
                  <el-dropdown-item>598050554</el-dropdown-item>
                </el-dropdown-menu>
              </el-dropdown>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

  export default {
    name: "About",
    data() {
      return {
        src: 'https://202007002.oss-cn-chengdu.aliyuncs.com/weix.jpg',
        imgList: [
            'https://images.unsplash.com/photo-1596052690099-7421fbdfe3c9?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60',
            'https://images.unsplash.com/photo-1596055318757-2bd56e35ed84?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60',
            'https://images.unsplash.com/photo-1596092720646-4713637c5976?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60'
        ],
        loading: true
      }
    },
    activated() {
      this.delayLoading()
    },
    methods: {
      delayLoading() {
        setTimeout(() => {
          this.loading = false
        }, 600)
      },
    }
  }

</script>

<style>
.el-carousel__button {
  background-color: #909399;
}
</style>
