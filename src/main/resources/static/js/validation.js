/**
 * 
 */
Vue.use(window.vuelidate.default);
const {required, email} = window.validators;
const app = new Vue({
	el: '#app',
	data: {
		price: '',
		content: '',
	},
	validations: {
		price:{
			required: validators.required
		}
	},
	methods: {
		submitForm(e){
			if(this.$v.$invalid){
				
				console.log('バリデーションエラー')
				e.preventDefault()
			}
	}
	}
});