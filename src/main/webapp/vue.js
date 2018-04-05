/**
 * Created by kirillparolys on 18.03.2018.
 */
var index = new Vue({
    el: '#app',
    data: {
        link: '',
        show: false
    },
    methods: {
        changeLoginLink:function() {
            this.show = true;
            this.link = '/login'
        },
        changeRegisterLink:function () {
            this.show = true;
            this.link = '/register'
        },
        changeAllUsersLink:function () {
            this.show = true;
            this.link = '/all-users'
        }
    }
});

var login = new Vue({
    el: '#loginApp',
    methods: {
        hideFrame: function () {
            index.data.show = false
        }
    }
});