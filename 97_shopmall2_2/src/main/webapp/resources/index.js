import imagesLoaded from 'imagesloaded';
import { gsap } from 'gsap';
import Screen from '../js/screen.js';

export default class Navigation {
  constructor(el) {
    this.DOM = {
      links: [...el.querySelectorAll('a')],
    };
    this.screens = [];
    [...document.querySelectorAll('.screen__item')].forEach((el) =>
      this.screens.push(new Screen(el))
    );
    this.current = 0;
    this.initEvents();
  }
  initEvents() {
    this.onMouseEnter = (ev) => {
      const position = this.DOM.links.indexOf(ev.target);

      if (position === this.current) {
        return false;
      }

      const currentScreen = this.screens[this.current];
      const nextScreen = this.screens[position];

      this.current = position;

      gsap.killTweensOf([currentScreen.DOM.el, nextScreen.DOM.el]);
      this.hideScreen(currentScreen);
      this.showScreen(nextScreen);
    };

    this.DOM.links.forEach((link) => {
      link.addEventListener('mouseenter', this.onMouseEnter);
    });
  }
  showScreen(screen) {
    gsap.timeline()
      .set(screen.DOM.el, { opacity: 1, zIndex: 1 })
      .to(screen.DOM.full, {
        duration: 1.8,
        ease: 'Power2.easeOut',
        startAt: { scale: 1.07 },
        scale: 1,
      });
  }
  hideScreen(screen) {
    gsap.timeline()
      .set(screen.DOM.el, { zIndex: 10 })
      .to(screen.DOM.el, {
        duration: 0.4,
        ease: 'Power2.easeOut',
        opacity: 0,
        onComplete: () => gsap.set(screen.DOM.el, { zIndex: 1 }),
      });
  }
}

// Preload images
const preloadImages = () => {
  return new Promise((resolve, reject) => {
    imagesLoaded(document.querySelectorAll('.screen'), { background: true }, resolve);
  });
};

// Preload fonts
const preloadFonts = () => {
  return new Promise((resolve, reject) => {
    WebFont.load({
      typekit: {
        id: 'cze1cgq',
      },
      active: resolve,
    });
  });
};

// Preload fonts and images
Promise.all([preloadImages(), preloadFonts()]).then(() => {
  new Navigation(document.querySelector('.menu'));
  // Remove loader (loading class)
  document.body.classList.remove('loading');
});