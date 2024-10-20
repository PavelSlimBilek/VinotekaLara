class Color {
    constructor(red = 0, green = 0, blue = 0) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    toValue(){
        return `rgb(${this.red}, ${this.green}, ${this.blue})`;
    }

    toString() {
        return this.toValue();
    }
}

class ColorPicker {
    constructor(colorBox) {
        this.colorBox = colorBox;
    }

    updateColor(color) {
        this.colorBox.style.backgroundColor = color.toValue();
        this.colorBox.innerText = color.toValue();
    }
}

function updateColor() {
    let red = document.getElementById('red').value;
    let green = document.getElementById('green').value;

    let blue = document.getElementById('blue').value;
    let color = new Color(red, green, blue);
    colorPicker.updateColor(color);

}

document.getElementById('red').addEventListener('input', updateColor);
document.getElementById('green').addEventListener('input', updateColor);
document.getElementById('blue').addEventListener('input', updateColor);

let colorPicker = new ColorPicker(
    document.getElementById('backgroundColor'),
);
