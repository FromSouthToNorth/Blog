<template>
  <div class="m-container-small m-padded-tb-big">
    <div class="ui container m-dialog-shadow">
      <!-- header -->
      <div class="ui top attached segment m-navbar"  v-if="tagList">
        <div class="ui middle aligned two column grid">
          <div class="column">
            <h3 class="ui title header">标签</h3>
          </div>
          <div class="right aligned column">
            共 <h4 class="ui orange header m-inline-block"> {{tagList.length}} </h4> 个
          </div>
        </div>
      </div>
      <!-- /header -->
      <div class="ui bottom attached segment teal" v-if="tagList">
        <router-link
          :to="'/tag/' + item.id"
          v-for="item in tagList"
          :key="item.id"
          tag="a"
          :class="{teal:$route.params.tagid == item.id}"
          @click.native="getBlog(item.id)"
          class="ui basic left pointing label tag-title m-margin-tb-tiny"
        >
          <span>{{item.name}}</span>
          <div class="detail">{{item.value}}</div>
        </router-link>
      </div>

      <blog-list :paging="paging" :pageNum="pageNum" :pageBlog="pageBlog"></blog-list>

    </div>
  </div>
</template>

<script>

  import BlogList from "components/blogList/BlogList"

  export default {
    name: "Tag",
    components: { BlogList },
    data() {
      return {
        tagList: null,
        pageBlog: {},
        tagId : 0,
        pageNum: 0,
        loading: []
      }
    },
    created() {
      this.openLoading();
    },
    // 组件处于活跃时
    activated() {
      $.get({
        url: 'tags',
        success: res => {
          this.tagList = res
          if (!this.$route.params.tagid) {
            this.$router.push('/tag/' + res[0].id)
            this.getBlog(res[0].id)
            this.loading.close();
          } else {
            this.getBlog(this.$route.params.tagid)
            this.loading.close();
          }
        }
      })
    },
    // 组件失去活跃时
    deactivated() {  },
    methods: {
      getBlog(id) {
        if (id !== -1) {
          this.tagId = id
        }
        $.get({
          url: 'blogTag',
          data: {'tagId': this.tagId, 'pageNum': this.pageNum},
          success: res => {
            this.pageBlog = res
          }
        })
      },
      paging(pageNum) {
        this.pageNum = pageNum
        this.getBlog(-1)
      },
      // 打开加载层
      openLoading() {
        this.loading = this.$loading({
          lock: true,
          text: "拼命读取中",
          spinner: "el-icon-loading",
          background: "rgba(0,0,0,0.7)"
        });
      }
    }
  }

</script>

<style scoped>

</style>
