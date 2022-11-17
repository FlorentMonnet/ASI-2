import Config from '../../config';
import { socket } from './index';

socket.on('eventName', (myVar) => {
    //code
});

const myService = {
    functionName() {
        socket.emit('oishs');
    },
};
export default myService;
