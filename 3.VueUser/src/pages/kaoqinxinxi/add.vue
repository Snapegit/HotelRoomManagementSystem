<template>
<div :style='{"width":"100%","padding":"80px 10%","margin":"10px auto","position":"relative","background":"#F6F6F6"}'>
    <el-form
	  :style='{"width":"100%","padding":"40px 20%","position":"relative","background":"#fff"}'
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="180px"
    >
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="员工账号" prop="yuangongzhanghao">
            <el-select  @change="yuangongzhanghaoChange" v-model="ruleForm.yuangongzhanghao" placeholder="请选择员工账号">
              <el-option
                  v-for="(item,index) in yuangongzhanghaoOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="员工姓名" prop="yuangongxingming">
            <el-input v-model="ruleForm.yuangongxingming" 
                placeholder="员工姓名" clearable :disabled=" false  ||ro.yuangongxingming"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="出勤天数" prop="chuqintianshu">
            <el-input v-model.number="ruleForm.chuqintianshu" 
                placeholder="出勤天数" clearable :disabled=" false  ||ro.chuqintianshu"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="请假天数" prop="qingjiatianshu">
            <el-input v-model.number="ruleForm.qingjiatianshu" 
                placeholder="请假天数" clearable :disabled=" false  ||ro.qingjiatianshu"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="迟到次数" prop="chidaocishu">
            <el-input v-model.number="ruleForm.chidaocishu" 
                placeholder="迟到次数" clearable :disabled=" false  ||ro.chidaocishu"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="早退次数" prop="zaotuicishu">
            <el-input v-model.number="ruleForm.zaotuicishu" 
                placeholder="早退次数" clearable :disabled=" false  ||ro.zaotuicishu"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="缺勤天数" prop="queqintianshu">
            <el-input v-model.number="ruleForm.queqintianshu" 
                placeholder="缺勤天数" clearable :disabled=" false  ||ro.queqintianshu"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="登记时间" prop="dengjishijian">
              <el-date-picker
				  :disabled=" false  ||ro.dengjishijian"
                  value-format="yyyy-MM-dd HH:mm:ss"
                  v-model="ruleForm.dengjishijian" 
                  type="datetime"
                  placeholder="登记时间">
              </el-date-picker>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="月份" prop="yuefen">
            <el-input v-model="ruleForm.yuefen" 
                placeholder="月份" clearable :disabled=" false  ||ro.yuefen"></el-input>
          </el-form-item>

      <el-form-item :style='{"padding":"0","margin":"0"}'>
        <el-button :style='{"border":"0","cursor":"pointer","padding":"0 40px","margin":"0 20px 0 0","outline":"none","color":"#000","borderRadius":"5px","background":"#5FE3EB","width":"auto","lineHeight":"40px","fontSize":"14px","height":"40px"}'  type="primary" @click="onSubmit">提交</el-button>
        <el-button :style='{"border":"0","cursor":"pointer","padding":"0 40px","margin":"0","outline":"none","color":"#fff","borderRadius":"5px","background":"#9E9E9E","width":"auto","lineHeight":"40px","fontSize":"14px","height":"40px"}' @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
</div>
</template>

<script>
  export default {
    data() {
	  let self = this
      return {
        id: '',
        baseUrl: '',
        ro:{
				yuangongzhanghao : false,
				yuangongxingming : false,
				chuqintianshu : false,
				qingjiatianshu : false,
				chidaocishu : false,
				zaotuicishu : false,
				queqintianshu : false,
				dengjishijian : false,
				yuefen : false,
				userid : false,
        },
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
        ruleForm: {
          yuangongzhanghao: '',
          yuangongxingming: '',
          chuqintianshu: '',
          qingjiatianshu: '',
          chidaocishu: '',
          zaotuicishu: '',
          queqintianshu: '',
          dengjishijian: '',
          yuefen: '',
          userid: '',
        },
        yuangongzhanghaoOptions: [],


        rules: {
          yuangongzhanghao: [
          ],
          yuangongxingming: [
          ],
          chuqintianshu: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          qingjiatianshu: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          chidaocishu: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          zaotuicishu: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          queqintianshu: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          dengjishijian: [
          ],
          yuefen: [
          ],
          userid: [
          ],
        },
		centerType: false,
      };
    },
    computed: {



    },
    components: {
    },
    created() {
		if(this.$route.query.centerType){
			this.centerType = true
		}
	  //this.bg();
      let type = this.$route.query.type ? this.$route.query.type : '';
      this.init(type);
      this.baseUrl = this.$config.baseUrl;
    },
    methods: {
      getMakeZero(s) {
          return s < 10 ? '0' + s : s;
      },
      // 下载
      download(file){
        window.open(`${file}`)
      },
      // 初始化
      init(type) {
        this.type = type;
        if(type=='cross'){
          var obj = JSON.parse(localStorage.getItem('crossObj'));
          for (var o in obj){
            if(o=='yuangongzhanghao'){
              this.ruleForm.yuangongzhanghao = obj[o];
              this.ro.yuangongzhanghao = true;
              continue;
            }
            if(o=='yuangongxingming'){
              this.ruleForm.yuangongxingming = obj[o];
              this.ro.yuangongxingming = true;
              continue;
            }
            if(o=='chuqintianshu'){
              this.ruleForm.chuqintianshu = obj[o];
              this.ro.chuqintianshu = true;
              continue;
            }
            if(o=='qingjiatianshu'){
              this.ruleForm.qingjiatianshu = obj[o];
              this.ro.qingjiatianshu = true;
              continue;
            }
            if(o=='chidaocishu'){
              this.ruleForm.chidaocishu = obj[o];
              this.ro.chidaocishu = true;
              continue;
            }
            if(o=='zaotuicishu'){
              this.ruleForm.zaotuicishu = obj[o];
              this.ro.zaotuicishu = true;
              continue;
            }
            if(o=='queqintianshu'){
              this.ruleForm.queqintianshu = obj[o];
              this.ro.queqintianshu = true;
              continue;
            }
            if(o=='dengjishijian'){
              this.ruleForm.dengjishijian = obj[o];
              this.ro.dengjishijian = true;
              continue;
            }
            if(o=='yuefen'){
              this.ruleForm.yuefen = obj[o];
              this.ro.yuefen = true;
              continue;
            }
            if(o=='userid'){
              this.ruleForm.userid = obj[o];
              this.ro.userid = true;
              continue;
            }
          }
        }else if(type=='edit'){
			this.info()
		}
        // 获取用户信息
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            var json = res.data.data;
          }
        });
        this.$http.get('option/yuangong/yuangongzhanghao', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.yuangongzhanghaoOptions = res.data.data;
          }
        });

		if (localStorage.getItem('raffleType') && localStorage.getItem('raffleType') != null) {
			localStorage.removeItem('raffleType')
			setTimeout(() => {
				this.onSubmit()
			}, 300)
		}
      },
      // 下二随
      yuangongzhanghaoChange () {
        this.$http.get('follow/yuangong/yuangongzhanghao?columnValue=' + this.ruleForm.yuangongzhanghao, {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            if(res.data.data.yuangongxingming){
              this.ruleForm.yuangongxingming = res.data.data.yuangongxingming
            }
          }
        });
      },

    // 多级联动参数
      // 多级联动参数
      info() {
        this.$http.get(`kaoqinxinxi/detail/${this.$route.query.id}`, {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.ruleForm = res.data.data;
          }
        });
      },
      // 提交
      onSubmit() {
			//更新跨表属性
			var crossuserid;
			var crossrefid;
			var crossoptnum;
			this.$refs["ruleForm"].validate(valid => {
				if(valid) {
					if(this.type=='cross'){
						var statusColumnName = localStorage.getItem('statusColumnName');
						var statusColumnValue = localStorage.getItem('statusColumnValue');
						if(statusColumnName && statusColumnName!='') {
							var obj = JSON.parse(localStorage.getItem('crossObj'));
							if(!statusColumnName.startsWith("[")) {
								for (var o in obj){
									if(o==statusColumnName){
										obj[o] = statusColumnValue;
									}
								}
								var table = localStorage.getItem('crossTable');
								this.$http.post(table+'/update', obj).then(res => {});
							} else {
								crossuserid=Number(localStorage.getItem('frontUserid'));
								crossrefid=obj['id'];
								crossoptnum=localStorage.getItem('statusColumnName');
								crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
							}
						}
					}
					if(crossrefid && crossuserid) {
						this.ruleForm.crossuserid=crossuserid;
						this.ruleForm.crossrefid=crossrefid;
						var params = {
							page: 1,
							limit: 10,
							crossuserid:crossuserid,
							crossrefid:crossrefid,
						}
						this.$http.get('kaoqinxinxi/list', {
							params: params
						}).then(res => {
							if(res.data.data.total>=crossoptnum) {
								this.$message({
									message: localStorage.getItem('tips'),
									type: 'error',
									duration: 1500,
								});
								return false;
							} else {
								// 跨表计算


								this.$http.post(`kaoqinxinxi/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
									if (res.data.code == 0) {
										this.$message({
											message: '操作成功',
											type: 'success',
											duration: 1500,
											onClose: () => {
												this.$router.go(-1);
											}
										});
									} else {
										this.$message({
											message: res.data.msg,
											type: 'error',
											duration: 1500
										});
									}
								});
							}
						});
					} else {


						this.$http.post(`kaoqinxinxi/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
							if (res.data.code == 0) {
								this.$message({
									message: '操作成功',
									type: 'success',
									duration: 1500,
									onClose: () => {
										this.$router.go(-1);
									}
								});
							} else {
								this.$message({
									message: res.data.msg,
									type: 'error',
									duration: 1500
								});
							}
						});
					}
				}
			});
		},
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
		// 返回
		back() {
			this.$router.go(-1);
		},
    }
  };
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item ::v-deep .el-form-item__label {
	  padding: 0 10px 0 0;
	  color: #000;
	  white-space: nowrap;
	  font-weight: 500;
	  width: 180px;
	  font-size: 14px;
	  line-height: 40px;
	  text-align: right;
	}
	
	.add-update-preview .el-form-item ::v-deep .el-form-item__content {
	  margin-left: 180px;
	}
	
	.add-update-preview .el-input ::v-deep .el-input__inner {
	  border: 1px solid #E2E3E5;
	  border-radius: 0;
	  padding: 0 12px;
	  box-shadow: none;
	  outline: none;
	  color: #000;
	  width: 400px;
	  font-size: 14px;
	  height: 40px;
	}
	.add-update-preview .el-input-number ::v-deep .el-input__inner {
		text-align: left;
	  border: 1px solid #E2E3E5;
	  border-radius: 0;
	  padding: 0 12px;
	  box-shadow: none;
	  outline: none;
	  color: #000;
	  width: 400px;
	  font-size: 14px;
	  height: 40px;
	}
	.add-update-preview .el-input-number ::v-deep .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number ::v-deep .el-input-number__increase {
		display: none;
	}
	
	.add-update-preview .el-select ::v-deep .el-input__inner {
	  border: 1px solid #E2E3E5;
	  border-radius: 0;
	  padding: 0 10px;
	  box-shadow: none;
	  outline: none;
	  color: #000;
	  width: 200px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview .el-date-editor ::v-deep .el-input__inner {
	  border: 1px solid #E2E3E5;
	  border-radius: 0;
	  padding: 0 10px 0 30px;
	  box-shadow: none;
	  outline: none;
	  color: #000;
	  width: 200px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview ::v-deep .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview ::v-deep .upload .upload-img {
	  border: 1px solid #E2E3E5;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #000;
	  width: 200px;
	  font-size: 32px;
	  line-height: 60px;
	  text-align: center;
	  height: 60px;
	}
	
	.add-update-preview ::v-deep .el-upload-list .el-upload-list__item {
	  border: 1px solid #E2E3E5;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #000;
	  width: 200px;
	  font-size: 32px;
	  line-height: 60px;
	  text-align: center;
	  height: 60px;
	}
	
	.add-update-preview ::v-deep .el-upload .el-icon-plus {
	  border: 1px solid #E2E3E5;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #000;
	  width: 200px;
	  font-size: 32px;
	  line-height: 60px;
	  text-align: center;
	  height: 60px;
	}
	
	.add-update-preview .el-textarea ::v-deep .el-textarea__inner {
	  border: 1px solidd #E2E3E5;
	  border-radius: 0;
	  padding: 12px;
	  box-shadow: none;
	  outline: none;
	  color: #000;
	  width: 400px;
	  font-size: 14px;
	  height: 120px;
	}
</style>
