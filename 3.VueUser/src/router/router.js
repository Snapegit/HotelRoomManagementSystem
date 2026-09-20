import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import payList from '../pages/pay'

import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import fangjianleixingList from '../pages/fangjianleixing/list'
import fangjianleixingDetail from '../pages/fangjianleixing/detail'
import fangjianleixingAdd from '../pages/fangjianleixing/add'
import fangjianxinxiList from '../pages/fangjianxinxi/list'
import fangjianxinxiDetail from '../pages/fangjianxinxi/detail'
import fangjianxinxiAdd from '../pages/fangjianxinxi/add'
import fangjianyuyueList from '../pages/fangjianyuyue/list'
import fangjianyuyueDetail from '../pages/fangjianyuyue/detail'
import fangjianyuyueAdd from '../pages/fangjianyuyue/add'
import fangjianruzhuList from '../pages/fangjianruzhu/list'
import fangjianruzhuDetail from '../pages/fangjianruzhu/detail'
import fangjianruzhuAdd from '../pages/fangjianruzhu/add'
import fangjiantuifangList from '../pages/fangjiantuifang/list'
import fangjiantuifangDetail from '../pages/fangjiantuifang/detail'
import fangjiantuifangAdd from '../pages/fangjiantuifang/add'
import fangjianxudingList from '../pages/fangjianxuding/list'
import fangjianxudingDetail from '../pages/fangjianxuding/detail'
import fangjianxudingAdd from '../pages/fangjianxuding/add'
import ruzhupingjiaList from '../pages/ruzhupingjia/list'
import ruzhupingjiaDetail from '../pages/ruzhupingjia/detail'
import ruzhupingjiaAdd from '../pages/ruzhupingjia/add'
import yuangongList from '../pages/yuangong/list'
import yuangongDetail from '../pages/yuangong/detail'
import yuangongAdd from '../pages/yuangong/add'
import kaoqinxinxiList from '../pages/kaoqinxinxi/list'
import kaoqinxinxiDetail from '../pages/kaoqinxinxi/detail'
import kaoqinxinxiAdd from '../pages/kaoqinxinxi/add'
import newstypeList from '../pages/newstype/list'
import newstypeDetail from '../pages/newstype/detail'
import newstypeAdd from '../pages/newstype/add'
import aboutusList from '../pages/aboutus/list'
import aboutusDetail from '../pages/aboutus/detail'
import aboutusAdd from '../pages/aboutus/add'
import discussfangjianxinxiList from '../pages/discussfangjianxinxi/list'
import discussfangjianxinxiDetail from '../pages/discussfangjianxinxi/detail'
import discussfangjianxinxiAdd from '../pages/discussfangjianxinxi/add'
import discussnewsList from '../pages/discussnews/list'
import discussnewsDetail from '../pages/discussnews/detail'
import discussnewsAdd from '../pages/discussnews/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'pay',
					component: payList,
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'yonghu',
					component: yonghuList
				},
				{
					path: 'yonghuDetail',
					component: yonghuDetail
				},
				{
					path: 'yonghuAdd',
					component: yonghuAdd
				},
				{
					path: 'fangjianleixing',
					component: fangjianleixingList
				},
				{
					path: 'fangjianleixingDetail',
					component: fangjianleixingDetail
				},
				{
					path: 'fangjianleixingAdd',
					component: fangjianleixingAdd
				},
				{
					path: 'fangjianxinxi',
					component: fangjianxinxiList
				},
				{
					path: 'fangjianxinxiDetail',
					component: fangjianxinxiDetail
				},
				{
					path: 'fangjianxinxiAdd',
					component: fangjianxinxiAdd
				},
				{
					path: 'fangjianyuyue',
					component: fangjianyuyueList
				},
				{
					path: 'fangjianyuyueDetail',
					component: fangjianyuyueDetail
				},
				{
					path: 'fangjianyuyueAdd',
					component: fangjianyuyueAdd
				},
				{
					path: 'fangjianruzhu',
					component: fangjianruzhuList
				},
				{
					path: 'fangjianruzhuDetail',
					component: fangjianruzhuDetail
				},
				{
					path: 'fangjianruzhuAdd',
					component: fangjianruzhuAdd
				},
				{
					path: 'fangjiantuifang',
					component: fangjiantuifangList
				},
				{
					path: 'fangjiantuifangDetail',
					component: fangjiantuifangDetail
				},
				{
					path: 'fangjiantuifangAdd',
					component: fangjiantuifangAdd
				},
				{
					path: 'fangjianxuding',
					component: fangjianxudingList
				},
				{
					path: 'fangjianxudingDetail',
					component: fangjianxudingDetail
				},
				{
					path: 'fangjianxudingAdd',
					component: fangjianxudingAdd
				},
				{
					path: 'ruzhupingjia',
					component: ruzhupingjiaList
				},
				{
					path: 'ruzhupingjiaDetail',
					component: ruzhupingjiaDetail
				},
				{
					path: 'ruzhupingjiaAdd',
					component: ruzhupingjiaAdd
				},
				{
					path: 'yuangong',
					component: yuangongList
				},
				{
					path: 'yuangongDetail',
					component: yuangongDetail
				},
				{
					path: 'yuangongAdd',
					component: yuangongAdd
				},
				{
					path: 'kaoqinxinxi',
					component: kaoqinxinxiList
				},
				{
					path: 'kaoqinxinxiDetail',
					component: kaoqinxinxiDetail
				},
				{
					path: 'kaoqinxinxiAdd',
					component: kaoqinxinxiAdd
				},
				{
					path: 'newstype',
					component: newstypeList
				},
				{
					path: 'newstypeDetail',
					component: newstypeDetail
				},
				{
					path: 'newstypeAdd',
					component: newstypeAdd
				},
				{
					path: 'aboutus',
					component: aboutusList
				},
				{
					path: 'aboutusDetail',
					component: aboutusDetail
				},
				{
					path: 'aboutusAdd',
					component: aboutusAdd
				},
				{
					path: 'discussfangjianxinxi',
					component: discussfangjianxinxiList
				},
				{
					path: 'discussfangjianxinxiDetail',
					component: discussfangjianxinxiDetail
				},
				{
					path: 'discussfangjianxinxiAdd',
					component: discussfangjianxinxiAdd
				},
				{
					path: 'discussnews',
					component: discussnewsList
				},
				{
					path: 'discussnewsDetail',
					component: discussnewsDetail
				},
				{
					path: 'discussnewsAdd',
					component: discussnewsAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
