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
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="房间名称" prop="fangjianmingcheng">
					<el-input v-model="ruleForm.fangjianmingcheng" placeholder="房间名称" clearable  :readonly="ro.fangjianmingcheng"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="房间名称" prop="fangjianmingcheng">
					<el-input v-model="ruleForm.fangjianmingcheng" placeholder="房间名称" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="upload" v-if="type!='info' && !ro.tupian" label="图片" prop="tupian">
					<file-upload
						tip="点击上传图片"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.tupian?ruleForm.tupian:''"
						@change="tupianUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="upload" v-else-if="ruleForm.tupian" label="图片" prop="tupian">
					<img v-if="ruleForm.tupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.tupian.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.tupian.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="一晚价格" prop="yiwanjiage">
					<el-input v-model.number="ruleForm.yiwanjiage" placeholder="一晚价格" clearable  :readonly="ro.yiwanjiage"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="一晚价格" prop="yiwanjiage">
					<el-input v-model="ruleForm.yiwanjiage" placeholder="一晚价格" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="date" v-if="type!='info'" label="入住时间" prop="ruzhushijian">
					<el-date-picker
						format="yyyy 年 MM 月 dd 日"
						value-format="yyyy-MM-dd"
						v-model="ruleForm.ruzhushijian" 
						type="date"
						:readonly="ro.ruzhushijian"
						placeholder="入住时间"
					></el-date-picker> 
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-else-if="ruleForm.ruzhushijian" label="入住时间" prop="ruzhushijian">
					<el-input v-model="ruleForm.ruzhushijian" placeholder="入住时间" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="用户账号" prop="yonghuzhanghao">
					<el-input v-model="ruleForm.yonghuzhanghao" placeholder="用户账号" clearable  :readonly="ro.yonghuzhanghao"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="用户账号" prop="yonghuzhanghao">
					<el-input v-model="ruleForm.yonghuzhanghao" placeholder="用户账号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="用户姓名" prop="yonghuxingming">
					<el-input v-model="ruleForm.yonghuxingming" placeholder="用户姓名" clearable  :readonly="ro.yonghuxingming"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="用户姓名" prop="yonghuxingming">
					<el-input v-model="ruleForm.yonghuxingming" placeholder="用户姓名" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="手机号码" prop="shoujihaoma">
					<el-input v-model="ruleForm.shoujihaoma" placeholder="手机号码" clearable  :readonly="ro.shoujihaoma"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="手机号码" prop="shoujihaoma">
					<el-input v-model="ruleForm.shoujihaoma" placeholder="手机号码" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="房间数量" prop="fangjianshuliang">
					<el-input v-model="ruleForm.fangjianshuliang" placeholder="房间数量" clearable  :readonly="ro.fangjianshuliang"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="房间数量" prop="fangjianshuliang">
					<el-input v-model="ruleForm.fangjianshuliang" placeholder="房间数量" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="date" v-if="type!='info'" label="退房日期" prop="tuifangriqi">
					<el-date-picker
						format="yyyy 年 MM 月 dd 日"
						value-format="yyyy-MM-dd"
						v-model="ruleForm.tuifangriqi" 
						type="date"
						:readonly="ro.tuifangriqi"
						placeholder="退房日期"
					></el-date-picker> 
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-else-if="ruleForm.tuifangriqi" label="退房日期" prop="tuifangriqi">
					<el-input v-model="ruleForm.tuifangriqi" placeholder="退房日期" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'" label="入住天数" prop="ruzhutianshu">
					<el-input v-model="ruzhutianshu" placeholder="入住天数" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-else-if="ruleForm.ruzhutianshu" label="入住天数" prop="ruzhutianshu">
					<el-input v-model="ruleForm.ruzhutianshu" placeholder="入住天数" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'" label="订单金额" prop="dingdanjine">
					<el-input v-model="dingdanjine" placeholder="订单金额" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-else-if="ruleForm.dingdanjine" label="订单金额" prop="dingdanjine">
					<el-input v-model="ruleForm.dingdanjine" placeholder="订单金额" readonly></el-input>
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
	isNumber,
	isIntNumer,
} from "@/utils/validate";
export default {
	data() {
		var validateNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isNumber(value)) {
				callback(new Error("请输入数字"));
			} else {
				callback();
			}
		};
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
				fangjianmingcheng : false,
				tupian : false,
				yiwanjiage : false,
				ruzhushijian : false,
				yonghuzhanghao : false,
				yonghuxingming : false,
				shoujihaoma : false,
				fangjianshuliang : false,
				tuifangriqi : false,
				ruzhutianshu : false,
				dingdanjine : false,
				ispay : false,
			},
			
			
			ruleForm: {
				fangjianmingcheng: '',
				tupian: '',
				yiwanjiage: '',
				ruzhushijian: '',
				yonghuzhanghao: '',
				yonghuxingming: '',
				shoujihaoma: '',
				fangjianshuliang: '',
				tuifangriqi: '',
				ruzhutianshu: '',
				dingdanjine: '',
			},
		

			
			rules: {
				fangjianmingcheng: [
				],
				tupian: [
				],
				yiwanjiage: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				ruzhushijian: [
				],
				yonghuzhanghao: [
				],
				yonghuxingming: [
				],
				shoujihaoma: [
				],
				fangjianshuliang: [
				],
				tuifangriqi: [
				],
				ruzhutianshu: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				dingdanjine: [
					{ validator: validateNumber, trigger: 'blur' },
				],
				ispay: [
				],
			}
		};
	},
	props: ["parent"],
	computed: {
		ruzhutianshu : {
			get: function () {
				let d = this.ruleForm
				let a = 'd1.ruzhushijian-d1.tuifangriqi'
				let n = a.split('-')
				let day = this.getDay(d[n[0].split('d1.')[1]], d[n[1].split('d1.')[1]])
				this.ruleForm.ruzhutianshu = day?day:0
				return day?day:0
			}
			
		},
		dingdanjine : {
			get: function () {
				let c = this.ruleForm
				let a = c.ruzhutianshu*c.yiwanjiage*c.fangjianshuliang
				this.ruleForm.dingdanjine = a?Number(a).toFixed(2):0
				return a?Number(a).toFixed(2):0
			}
			
		},



	},
    components: {
    },
	created() {
		this.ruleForm.ruzhushijian = this.getCurDate()
		this.ruleForm.tuifangriqi = this.getCurDate()
	},
	methods: {
		// 获取日期间隔 单位天
		getDay(first, last) {
			let date1 = new Date(first)
			let date2 = new Date(last)
			let a = date1.getTime();
			let b = date2.getTime();
			var count = 0;
			for (var i = a; i < b; i += 24 * 3600 * 1000) {
				count++;
			}
			return count;
		},
		
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
						if(o=='fangjianmingcheng'){
							this.ruleForm.fangjianmingcheng = obj[o];
							this.ro.fangjianmingcheng = true;
							continue;
						}
						if(o=='tupian'){
							this.ruleForm.tupian = obj[o];
							this.ro.tupian = true;
							continue;
						}
						if(o=='yiwanjiage'){
							this.ruleForm.yiwanjiage = obj[o];
							this.ro.yiwanjiage = true;
							continue;
						}
						if(o=='ruzhushijian'){
							this.ruleForm.ruzhushijian = obj[o];
							this.ro.ruzhushijian = true;
							continue;
						}
						if(o=='yonghuzhanghao'){
							this.ruleForm.yonghuzhanghao = obj[o];
							this.ro.yonghuzhanghao = true;
							continue;
						}
						if(o=='yonghuxingming'){
							this.ruleForm.yonghuxingming = obj[o];
							this.ro.yonghuxingming = true;
							continue;
						}
						if(o=='shoujihaoma'){
							this.ruleForm.shoujihaoma = obj[o];
							this.ro.shoujihaoma = true;
							continue;
						}
						if(o=='fangjianshuliang'){
							this.ruleForm.fangjianshuliang = obj[o];
							this.ro.fangjianshuliang = true;
							continue;
						}
						if(o=='tuifangriqi'){
							this.ruleForm.tuifangriqi = obj[o];
							this.ro.tuifangriqi = true;
							continue;
						}
						if(o=='ruzhutianshu'){
							this.ruleForm.ruzhutianshu = obj[o];
							this.ro.ruzhutianshu = true;
							continue;
						}
						if(o=='dingdanjine'){
							this.ruleForm.dingdanjine = obj[o];
							this.ro.dingdanjine = true;
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
					if(((json.yonghuzhanghao!=''&&json.yonghuzhanghao) || json.yonghuzhanghao==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.yonghuzhanghao = json.yonghuzhanghao
						this.ro.yonghuzhanghao = true;
					}
					if(((json.yonghuxingming!=''&&json.yonghuxingming) || json.yonghuxingming==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.yonghuxingming = json.yonghuxingming
						this.ro.yonghuxingming = true;
					}
					if(((json.shoujihaoma!=''&&json.shoujihaoma) || json.shoujihaoma==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.shoujihaoma = json.shoujihaoma
						this.ro.shoujihaoma = true;
					}
				} else {
					this.$message.error(data.msg);
				}
			});
			
		},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `fangjiantuifang/info/${id}`,
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
		this.ruleForm.ispay = '未支付'
		if(this.ruleForm.ruzhutianshu==0){
			this.$message.error('入住天数不能为空')
			return false
		}
		if(this.ruleForm.dingdanjine==0){
			this.$message.error('订单金额不能为空')
			return false
		}
	if(this.ruleForm.tupian!=null) {
		this.ruleForm.tupian = this.ruleForm.tupian.replace(new RegExp(this.$base.url,"g"),"");
	}
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
					url: "fangjiantuifang/page", 
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
								url: `fangjiantuifang/${!this.ruleForm.id ? "save" : "update"}`,
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
											this.parent.fangjiantuifangCrossAddOrUpdateFlag = false;
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
				url: `fangjiantuifang/${!this.ruleForm.id ? "save" : "update"}`,
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
							this.parent.fangjiantuifangCrossAddOrUpdateFlag = false;
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
      this.parent.fangjiantuifangCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    tupianUploadChange(fileUrls) {
	    this.ruleForm.tupian = fileUrls;
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
