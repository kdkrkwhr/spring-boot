importScripts('https://www.gstatic.com/firebasejs/5.9.2/firebase-app.js');
importScripts('https://www.gstatic.com/firebasejs/5.9.2/firebase-messaging.js');

// Initialize Firebase
let firebaseConfig = {
  apiKey: "AIzaSyClRifQIoEyg767dth7y0X_wKk3aCxkij8",
  authDomain: "fcm-web-74ae9.firebaseapp.com",
  projectId: "fcm-web-74ae9",
  storageBucket: "fcm-web-74ae9.appspot.com",
  messagingSenderId: "1089037401421",
  appId: "1:1089037401421:web:019577b1b2a8f6669c4b04",
  measurementId: "G-DR9TMKECJC"
};
firebase.initializeApp(firebaseConfig);
const messaging = firebase.messaging();