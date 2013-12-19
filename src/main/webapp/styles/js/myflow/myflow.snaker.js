(function($){
var myflow = $.myflow;

$.extend(true,myflow.config.rect,{
	attr : {
	r : 8,
	fill : '#F6F7FF',
	stroke : '#03689A',
	"stroke-width" : 2
}
});

$.extend(true,myflow.config.props.props,{
	name : {name:'name', label:'名称', value:'test1', editor:function(){return new myflow.editors.inputEditor();}},
	displayName : {name:'displayName', label:'显示名称', value:'test1', editor:function(){return new myflow.editors.inputEditor();}},
	expireTime : {name:'expireTime', label:'期望完成时间', value:'test1', editor:function(){return new myflow.editors.inputEditor();}},
	instanceUrl : {name:'instanceUrl', label:'实例启动Url', value:'', editor:function(){return new myflow.editors.inputEditor();}},
	instanceNoClass : {name:'instanceNoClass', label:'实例编号生成类', value:'', editor:function(){return new myflow.editors.inputEditor();}}
});


$.extend(true,myflow.config.tools.states,{
			start : {
				showType: 'image',
				type : 'start',
				name : {text:'<<start>>'},
				text : {text:'start'},
				img : {src : 'images/48/start_event_empty.png',width : 48, height:48},
				attr : {width:50 ,heigth:50 },
				props : {
					name: {name:'name',label: '名称', value:'start', editor: function(){return new myflow.editors.textEditor();}}
				}},
			end : {
				showType: 'image',
				type : 'end',
				name : {text:'<<end>>'},
				text : {text:'end'},
				img : {src : 'images/48/end_event_terminate.png',width : 48, height:48},
				attr : {width:50 ,heigth:50 },
				props : {
					name: {name:'name',label: '名称', value:'end', editor: function(){return new myflow.editors.textEditor();}}
				}},
			task : {
				showType: 'text',
				type : 'task',
				name : {text:'<<task>>'},
				text : {text:'task'},
				img : {src : 'images/48/task_empty.png',width :48, height:48},
				props : {
					name: {name:'name',label: '名称', value:'', editor: function(){return new myflow.editors.inputEditor();}},
					displayName: {name:'displayName',label: '显示名称', value:'', editor: function(){return new myflow.editors.textEditor();}},
					assignee: {name:'assignee', label: '参与者', value:'', editor: function(){return new myflow.editors.inputEditor();}},
					form: {name:'form', label : '表单', value:'', editor: function(){return new myflow.editors.inputEditor();}},
					performType: {name:'performType', label : '参与类型', value:'', editor: function(){return new myflow.editors.selectEditor([{name:'ANY',value:'ANY'},{name:'ALL',value:'ALL'}]);}}
				}},
			custom : {
				showType: 'text',
				type : 'custom',
				name : {text:'<<custom>>'},
				text : {text:'custom'},
				img : {src : 'images/48/task_empty.png',width :48, height:48},
				props : {
					name: {name:'name',label: '名称', value:'', editor: function(){return new myflow.editors.inputEditor();}},
					displayName: {name:'displayName',label: '显示名称', value:'', editor: function(){return new myflow.editors.textEditor();}},
					clazz: {name:'clazz', label: '类路径', value:'', editor: function(){return new myflow.editors.inputEditor();}},
					methodName: {name:'methodName', label : '方法名称', value:'', editor: function(){return new myflow.editors.inputEditor();}},
					args: {name:'args', label : '参数变量', value:'', editor: function(){return new myflow.editors.inputEditor();}},
					var: {name:'var', label : '变量名称', value:'', editor: function(){return new myflow.editors.inputEditor();}}
				}},
			subprocess : {
				showType: 'text',
				type : 'subprocess',
				name : {text:'<<subprocess>>'},
				text : {text:'subprocess'},
				img : {src : 'images/48/task_empty.png',width :48, height:48},
				props : {
					name: {name:'name',label: '名称', value:'', editor: function(){return new myflow.editors.inputEditor();}},
					displayName: {name:'displayName',label: '显示名称', value:'', editor: function(){return new myflow.editors.textEditor();}},
					processName: {name:'processName', label: '子流程名称', value:'', editor: function(){return new myflow.editors.inputEditor();}}
				}},
			decision : {
				showType: 'image',
				type : 'decision',
				name : {text:'<<decision>>'},
				text : {text:'decision'},
				img : {src : 'images/48/gateway_exclusive.png',width :48, height:48},
				props : {
					name: {name:'name',label: '名称', value:'', editor: function(){return new myflow.editors.inputEditor();}},
					expr: {name:'expr',label: '决策表达式', value:'', editor: function(){return new myflow.editors.inputEditor();}},
					handleClass: {name:'handleClass', label: '处理类名称', value:'', editor: function(){return new myflow.editors.inputEditor();}}
				}},
			fork : {
				showType: 'image',
				type : 'fork',
				name : {text:'<<fork>>'},
				text : {text:'fork'},
				img : {src : 'images/48/gateway_parallel.png',width :48, height:48},
				props : {
					name: {name:'name',label: '名称', value:'', editor: function(){return new myflow.editors.inputEditor();}}
				}},
			join : {
				showType: 'image',
				type : 'join',
				name : {text:'<<join>>'},
				text : {text:'join'},
				img : {src : 'images/48/gateway_parallel.png',width :48, height:48},
				props : {
					name: {name:'name',label: '名称', value:'', editor: function(){return new myflow.editors.inputEditor();}}
				}}
});
})(jQuery);