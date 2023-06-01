// HTML 요소 선택
const el = document.querySelector('.screen-container');

// Screen 클래스의 인스턴스 생성
const screen = new Screen(el);

export default class Screen {
    constructor(el) {
        this.DOM = {el: el};
        this.DOM.full = this.DOM.el.querySelector('.screen--full');
    }
}