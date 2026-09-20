<template>
	<div class="addEdit-block" :style='{"padding":"30px"}'>
		<el-form
			:style='{"borderRadius":"6px","padding":"30px"}'
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="180px"
		>
			<template >
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="select" v-if="type!='info'" label="员工账号" prop="yuangongzhanghao">
					<el-select :disabled="ro.yuangongzhanghao" @change="yuangongzhanghaoChange" v-model="ruleForm.yuangongzhanghao" placeholder="请选择员工账号">
						<el-option
							v-for="(item,index) in yuangongzhanghaoOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-else-if="ruleForm.yuangongzhanghao" label="员工账号" prop="yuangongzhanghao">
					<el-input v-model="ruleForm.yuangongzhanghao" placeholder="员工账号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="员工姓名" prop="yuangongxingming">
					<el-input v-model="ruleForm.yuangongxingming" placeholder="员工姓名" clearable  :readonly="ro.yuangongxingming"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="员工姓名" prop="yuangongxingming">
					<el-input v-model="ruleForm.yuangongxingming" placeholder="员工姓名" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="出勤天数" prop="chuqintianshu">
					<el-input v-model.number="ruleForm.chuqintianshu" placeholder="出勤天数" clearable  :readonly="ro.chuqintianshu"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="出勤天数" prop="chuqintianshu">
					<el-input v-model="ruleForm.chuqintianshu" placeholder="出勤天数" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="请假天数" prop="qingjiatianshu">
					<el-input v-model.number="ruleForm.qingjiatianshu" placeholder="请假天数" clearable  :readonly="ro.qingjiatianshu"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="请假天数" prop="qingjiatianshu">
					<el-input v-model="ruleForm.qingjiatianshu" placeholder="请假天数" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="迟到次数" prop="chidaocishu">
					<el-input v-model.number="ruleForm.chidaocishu" placeholder="迟到次数" clearable  :readonly="ro.chidaocishu"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="迟到次数" prop="chidaocishu">
					<el-input v-model="ruleForm.chidaocishu" placeholder="迟到次数" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="早退次数" prop="zaotuicishu">
					<el-input v-model.number="ruleForm.zaotuicishu" placeholder="早退次数" clearable  :readonly="ro.zaotuicishu"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="早退次数" prop="zaotuicishu">
					<el-input v-model="ruleForm.zaotuicishu" placeholder="早退次数" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="缺勤天数" prop="queqintianshu">
					<el-input v-model.number="ruleForm.queqintianshu" placeholder="缺勤天数" clearable  :readonly="ro.queqintianshu"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="缺勤天数" prop="queqintianshu">
					<el-input v-model="ruleForm.queqintianshu" placeholder="缺勤天数" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="date" v-if="type!='info'" label="登记时间" prop="dengjishijian">
					<el-date-picker
						value-format="yyyy-MM-dd HH:mm:ss"
						v-model="ruleForm.dengjishijian" 
						type="datetime"
						:readonly="ro.dengjishijian"
						placeholder="登记时间"
					></el-date-picker>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-else-if="ruleForm.dengjishijian" label="登记时间" prop="dengjishijian">
					<el-input v-model="ruleForm.dengjishijian" placeholder="登记时间" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="月份" prop="yuefen">
					<el-input v-model="ruleForm.yuefen" placeholder="月份" clearable  :readonly="ro.yuefen"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="月份" prop="yuefen">
					<el-input v-model="ruleForm.yuefen" placeholder="月份" readonly></el-input>
				</el-form-item>
			</template>
			<el-form-item :style='{"padding":"0","margin":"0"}' class="btn">
				<el-button class="btn3"  v-if="type!='info'" type="success" @click="onSubmit">
					<span class="icon iconfont icon-xihuan" :style='{"margin":"0 2px","fontSize":"14px","color":"#fff","height":"40px"}'></span>
					提交
				</el-button>
				<el-button class="btn4" v-if="type!='info'" type="success" @click="back()">
					<span class="icon iconfont icon-xihuan" :style='{"margin":"0 2px","fontSize":"14px","color":"#fff","height":"40px"}'></span>
					取消
				</el-button>
				<el-button class="btn5" v-if="type=='info'" type="success" @click="back()">
					<span class="icon iconfont icon-xihuan" :style='{"margin":"0 2px","fontSize":"14px","color":"#fff","height":"40px"}'></span>
					返回
				</el-button>
			</el-form-item>
		</el-form>
    

  </div>
</template>
<script>
import { 
	isIntNumer,
} from "@/utils/validate";
export default {
	data() {
		var validateIntNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isIntNumer(value)) {
				callback(new Error("请输入整数"));
			} else {
				callback();
			}
		};
		return {
			id: '',
			type: '',
			
			
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
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				qingjiatianshu: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				chidaocishu: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				zaotuicishu: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				queqintianshu: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				dengjishijian: [
				],
				yuefen: [
				],
				userid: [
				],
			}
		};
	},
	props: ["parent"],
	computed: {



	},
    components: {
    },
	created() {
	},
	methods: {
		
		// 下载
		download(file){
			window.open(`${file}`)
		},
		// 初始化
		init(id,type) {
			if (id) {
				this.id = id;
				this.type = type;
			}
			if(this.type=='info'||this.type=='else'){
				this.info(id);
			}else if(this.type=='logistics'){
				this.logistics=false;
				this.info(id);
			}else if(this.type=='cross'){
				var obj = this.$storage.getObj('crossObj');
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
			}
			// 获取用户信息
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					var json = data.data;
				} else {
					this.$message.error(data.msg);
				}
			});
            this.$http({
				url: `option/yuangong/yuangongzhanghao`,
				method: "get"
            }).then(({ data }) => {
				if (data && data.code === 0) {
					this.yuangongzhanghaoOptions = data.data;
				} else {
					this.$message.error(data.msg);
				}
            });
			
		},
			// 下二随
			yuangongzhanghaoChange () {
				this.$http({
					url: `follow/yuangong/yuangongzhanghao?columnValue=`+ this.ruleForm.yuangongzhanghao,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						if(data.data.yuangongxingming){
							this.ruleForm.yuangongxingming = data.data.yuangongxingming
						}
					} else {
						this.$message.error(data.msg);
					}
				});
			},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `kaoqinxinxi/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
        //解决前台上传图片后台不显示的问题
        let reg=new RegExp('../../../upload','g')//g代表全部
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // 提交
    onSubmit() {
var objcross = this.$storage.getObj('crossObj');
      //更新跨表属性
       var crossuserid;
       var crossrefid;
       var crossoptnum;
       if(this.type=='cross'){
                var statusColumnName = this.$storage.get('statusColumnName');
                var statusColumnValue = this.$storage.get('statusColumnValue');
                if(statusColumnName!='') {
                        var obj = this.$storage.getObj('crossObj');
                       if(statusColumnName && !statusColumnName.startsWith("[")) {
                               for (var o in obj){
                                 if(o==statusColumnName){
                                   obj[o] = statusColumnValue;
                                 }
                               }
                               var table = this.$storage.get('crossTable');
                             this.$http({
                                 url: `${table}/update`,
                                 method: "post",
                                 data: obj
                               }).then(({ data }) => {});
                       } else {
                               crossuserid=this.$storage.get('userid');
                               crossrefid=obj['id'];
                               crossoptnum=this.$storage.get('statusColumnName');
                               crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                        }
                }
        }
		this.$refs["ruleForm"].validate(valid => {
			if (valid) {
				if(crossrefid && crossuserid) {
					this.ruleForm.crossuserid = crossuserid;
					this.ruleForm.crossrefid = crossrefid;
					let params = { 
						page: 1, 
						limit: 10, 
						crossuserid:this.ruleForm.crossuserid,
						crossrefid:this.ruleForm.crossrefid,
					} 
				this.$http({ 
					url: "kaoqinxinxi/page", 
					method: "get", 
					params: params 
				}).then(({ 
					data 
				}) => { 
					if (data && data.code === 0) { 
						if(data.data.total>=crossoptnum) {
							this.$message.error(this.$storage.get('tips'));
							return false;
						} else {
							this.$http({
								url: `kaoqinxinxi/${!this.ruleForm.id ? "save" : "update"}`,
								method: "post",
								data: this.ruleForm
							}).then(({ data }) => {
								if (data && data.code === 0) {
									this.$message({
										message: "操作成功",
										type: "success",
										duration: 1500,
										onClose: () => {
											this.parent.showFlag = true;
											this.parent.addOrUpdateFlag = false;
											this.parent.kaoqinxinxiCrossAddOrUpdateFlag = false;
											this.parent.search();
											this.parent.contentStyleChange();
										}
									});
								} else {
									this.$message.error(data.msg);
								}
							});

						}
					} else { 
				} 
			});
		} else {
			this.$http({
				url: `kaoqinxinxi/${!this.ruleForm.id ? "save" : "update"}`,
				method: "post",
			   data: this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "操作成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.parent.showFlag = true;
							this.parent.addOrUpdateFlag = false;
							this.parent.kaoqinxinxiCrossAddOrUpdateFlag = false;
							this.parent.search();
							this.parent.contentStyleChange();
						}
					});
				} else {
					this.$message.error(data.msg);
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
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.kaoqinxinxiCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
  }
};
</script>
<style lang="scss" scoped>
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item ::v-deep .el-form-item__label {
	  	  padding: 0 10px 0 0;
	  	  color: #666;
	  	  font-weight: 600;
	  	  width: 180px;
	  	  font-size: 14px;
	  	  line-height: 40px;
	  	  text-align: right;
	  	}
	
	.add-update-preview .el-form-item ::v-deep .el-form-item__content {
	  margin-left: 180px;
	}
	
	.add-update-preview .el-input ::v-deep .el-input__inner {
	  	  border: 2px solid #ddd;
	  	  border-radius: 4px;
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
	  	  border: 2px solid #ddd;
	  	  border-radius: 4px;
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
	  	  border: 2px solid #ddd;
	  	  border-radius: 4px;
	  	  padding: 0 10px;
	  	  outline: none;
	  	  color: #000;
	  	  width: 200px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-date-editor ::v-deep .el-input__inner {
	  	  border: 2px solid #ddd;
	  	  border-radius: 4px;
	  	  padding: 0 10px 0 30px;
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
	  	  border: 2px solid #ddd;
	  	  cursor: pointer;
	  	  border-radius: 4px;
	  	  color: #999;
	  	  background: #fff;
	  	  font-weight: 400;
	  	  width: 120px;
	  	  font-size: 32px;
	  	  line-height: 80px;
	  	  text-align: center;
	  	  height: 80px;
	  	}
	
	.add-update-preview ::v-deep .el-upload-list .el-upload-list__item {
	  	  border: 2px solid #ddd;
	  	  cursor: pointer;
	  	  border-radius: 4px;
	  	  color: #999;
	  	  background: #fff;
	  	  font-weight: 400;
	  	  width: 120px;
	  	  font-size: 32px;
	  	  line-height: 80px;
	  	  text-align: center;
	  	  height: 80px;
	  	}
	
	.add-update-preview ::v-deep .el-upload .el-icon-plus {
	  	  border: 2px solid #ddd;
	  	  cursor: pointer;
	  	  border-radius: 4px;
	  	  color: #999;
	  	  background: #fff;
	  	  font-weight: 400;
	  	  width: 120px;
	  	  font-size: 32px;
	  	  line-height: 80px;
	  	  text-align: center;
	  	  height: 80px;
	  	}
	
	.add-update-preview .el-textarea ::v-deep .el-textarea__inner {
	  	  border: 2px solid #ddd;
	  	  border-radius: 4px;
	  	  padding: 12px;
	  	  outline: none;
	  	  color: #000;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: 120px;
	  	}
	
	.add-update-preview .btn .btn1 {
				border: 0;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				color: #fff;
				background: #6aab9c;
				font-weight: 400;
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn1:hover {
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn2 {
				border: 0;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				color: #fff;
				background: #6aab9c;
				font-weight: 400;
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn2:hover {
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn3 {
				border: 0;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				color: #fff;
				background: #6aab9c;
				font-weight: 400;
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn3:hover {
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn4 {
				border: 0;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				color: #fff;
				background: #6aab9c;
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn4:hover {
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn5 {
				border: 0;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				color: #fff;
				background: #6aab9c;
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn5:hover {
				opacity: 0.8;
			}
</style>
