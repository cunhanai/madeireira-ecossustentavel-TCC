/*--------------  overview-chart start ------------*/
if ($('#verview-shart').length) {
    var myConfig = {
        "type": "line",

        "scale-x": { //X-Axis
            "labels": ["", "Jan", "Fev", "Mar", "Abr", "Mai", "Jun", "Jul", "Ago", "Set", "Out", "Nov", "Dez"],
            "label": {
                "font-size": 14,
                "offset-x": 0,
            },
            "item": { //Scale Items (scale values or labels)
                "font-size": 10,
            },
            "guide": { //Guides
                "visible": false,
                "line-style": "solid", //"solid", "dotted", "dashed", "dashdot"
                "alpha": 1
            }
        },
        "plot": { "aspect": "spline" },
        "series": [{
                "values": [20, 25, 30, 35, 45, 40, 40, 35, 40, 35, 40, 50, 60],
                "line-color": "#F8CB3F",
                /* "dotted" | "dashed" */
                "line-width": 5 /* in pixels */ ,
                "marker": { /* Marker object */
                    "background-color": "#edc137",
                    /* hexadecimal or RGB value */
                    "size": 5,
                    /* in pixels */
                    "border-color": "#edc137",
                    /* hexadecimal or RBG value */
                }
            },
            {
                "values": [15, 25, 45, 60, 30, 43, 64, 70, 80, 50, 55, 40, 30],
                "line-color": "#12C498",
                /* "dotted" | "dashed" */
                "line-width": 5 /* in pixels */ ,
                "marker": { /* Marker object */
                    "background-color": "#0bb087",
                    /* hexadecimal or RGB value */
                    "size": 5,
                    /* in pixels */
                    "border-color": "#0bb087",
                    /* hexadecimal or RBG value */
                }
            }
        ]
    };

    zingchart.render({
        id: 'verview-shart',
        data: myConfig,
        height: "100%",
        width: "100%"
    });
}

/*--------------  overview-chart END ------------*/
