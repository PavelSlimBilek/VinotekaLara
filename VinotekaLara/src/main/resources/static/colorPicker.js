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

    updateColor(backgroundColor, fontColor) {
        this.colorBox.style.backgroundColor = backgroundColor.toValue();
        this.colorBox.style.color = fontColor.toValue();
    }
}

function updateColor() {
    let bckRed = document.getElementById('bckRed').value;
    let bckGreen = document.getElementById('bckGreen').value;
    let bckBlue = document.getElementById('bckBlue').value;

    let fntRed = document.getElementById('fntRed').value;
    let fntGreen = document.getElementById('fntGreen').value;
    let fntBlue = document.getElementById('fntBlue').value;

    let backgroundColor = new Color(bckRed, bckGreen, bckBlue);
    let fontColor = new Color(fntRed, fntGreen, fntBlue);
    colorPicker.updateColor(backgroundColor, fontColor);

}

document.getElementById('bckRed').addEventListener('input', updateColor);
document.getElementById('bckGreen').addEventListener('input', updateColor);
document.getElementById('bckBlue').addEventListener('input', updateColor);

document.getElementById('fntRed').addEventListener('input', updateColor);
document.getElementById('fntGreen').addEventListener('input', updateColor);
document.getElementById('fntBlue').addEventListener('input', updateColor);

let colorPicker = new ColorPicker(
    document.getElementById('previewBox'),
);
