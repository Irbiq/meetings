"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = require("@angular/core");
var platform_browser_1 = require("@angular/platform-browser");
var forms_1 = require("@angular/forms");
var router_1 = require("@angular/router");
var video_component_1 = require("./components/course/_course_step/video-step/video.component");
var app_homehead_1 = require("./components/homehead/app.homehead");
var auth_guard_1 = require("./components/_guards/auth.guard");
//import {CourseComponent} from "./components/course/app.course";//////////////////
var login_component_1 = require("./components/login/login.component");
var register_component_1 = require("./components/register/register.component");
var http_1 = require("@angular/http");
var app_component_1 = require("./app.component");
var app_navbar_1 = require("./components/navbar/app.navbar");
var authentication_service_1 = require("./components/_services/authentication.service");
var user_service_1 = require("./components/_services/user.service");
var fake_backend_1 = require("./components/_helpers/fake-backend");
var testing_1 = require("@angular/http/testing");
var ng_bootstrap_1 = require("@ng-bootstrap/ng-bootstrap");
var add_info_component_1 = require("./components/add_course/info/add-info.component");
var add_course_component_1 = require("./components/add_course/add-course/add-course.component");
var new_step_component_1 = require("./components/add_course/addstep/new-step.component");
var add_video_component_1 = require("./components/add_course/video/add-video.component");
var add_text_component_1 = require("./components/add_course/text/add-text.component");
var add_test_component_1 = require("./components/add_course/test/add-test.component");
var add_task_component_1 = require("./components/add_course/task/add-task.component");
var test_component_1 = require("./components/course/_course_step/test-step/test.component");
var text_component_1 = require("./components/course/_course_step/text-step/text.component");
var course_service_1 = require("./components/_services/_course/course.service");
var text_service_1 = require("./components/_services/_course/text.service");
var video_service_1 = require("./components/_services/_course/video.service");
var test_service_1 = require("./components/_services/_course/test.service");
var task_service_1 = require("./components/_services/_course/task.service");
var info_service_1 = require("./components/_services/_course/info.service");
var app_course_1 = require("./components/course-view/app.course");
var text_component_2 = require("./components/course-view/_course_step/text-step/text.component");
var start_course_component_1 = require("./components/course-view/_course_step/start-course/start-course.component");
/*const addStepRoutes: Routes = [
    { path: 'add_course', component: AddCourseInfoComponent},
    //{ path: '**', component: StepsComponent}
];*/
var addStepRoute = [
    { path: 'video', component: add_video_component_1.AddVideoComponent },
    { path: 'text', component: add_text_component_1.AddTextComponent },
    { path: 'task', component: add_task_component_1.AddTaskComponent },
    { path: 'test', component: add_test_component_1.AddTestComponent },
    { path: 'video-view/:id', component: video_component_1.VideoComponent },
    { path: 'text-view/:id', component: text_component_1.TextComponent },
    { path: 'task-view/:id', component: add_task_component_1.AddTaskComponent },
    { path: 'test-view/:id', component: add_test_component_1.AddTestComponent },
];
var newStepsRoute = [
    { path: 'new', component: add_course_component_1.AddCourseComponent, children: addStepRoute },
];
var courseRoutes = [
    { path: 'video-view/:id', /*'video/:id',*/ component: video_component_1.VideoComponent },
    { path: 'text-view/:id', /*'text/:id', */ component: text_component_2.TextComponent1 },
    { path: 'test/:id', component: test_component_1.TestComponent },
    //{ path: 'task/:id', component: VideoComponent},
    { path: '**', component: start_course_component_1.StartCourseComponent }
];
var routes = [
    /*!!!*/ { path: '', component: app_homehead_1.HomeheadComponent, canActivate: [auth_guard_1.AuthGuard] },
    { path: 'course/:id', component: app_course_1.CourseComponent, children: courseRoutes },
    { path: 'add', component: add_info_component_1.AddCourseInfoComponent },
    { path: 'steps', component: add_course_component_1.AddCourseComponent, children: addStepRoute },
    { path: 'login', component: login_component_1.LoginComponent },
    { path: 'register', component: register_component_1.RegisterComponent },
    // otherwise redirect to home
    { path: '**', redirectTo: '' }
];
var AppModule = (function () {
    function AppModule() {
    }
    return AppModule;
}());
AppModule = __decorate([
    core_1.NgModule({
        imports: [router_1.RouterModule.forRoot(routes), platform_browser_1.BrowserModule, forms_1.FormsModule, http_1.HttpModule, ng_bootstrap_1.NgbModule.forRoot()],
        declarations: [
            //AlertComponent,
            app_component_1.AppComponent,
            login_component_1.LoginComponent,
            register_component_1.RegisterComponent,
            app_navbar_1.NavbarComponent,
            app_homehead_1.HomeheadComponent,
            add_info_component_1.AddCourseInfoComponent,
            app_course_1.CourseComponent,
            //////Text Need to delete///////////
            text_component_2.TextComponent1,
            start_course_component_1.StartCourseComponent,
            ////////////////////////////////////
            //  SignupComponent,
            video_component_1.VideoComponent,
            test_component_1.TestComponent,
            //////////////
            add_course_component_1.AddCourseComponent,
            new_step_component_1.NewStepComponent,
            /////////////////
            text_component_1.TextComponent,
            ///////////////
            add_video_component_1.AddVideoComponent,
            add_task_component_1.AddTaskComponent,
            add_test_component_1.AddTestComponent,
            add_text_component_1.AddTextComponent,
        ],
        providers: [
            //////////////////////////
            text_service_1.TextService,
            video_service_1.VideoService,
            test_service_1.TestService,
            task_service_1.TaskService,
            info_service_1.InfoService,
            /////////////////////////
            auth_guard_1.AuthGuard,
            //  AlertService,
            authentication_service_1.AuthenticationService,
            user_service_1.UserService,
            //
            //
            course_service_1.CourseService,
            // providers used to create fake backend
            fake_backend_1.fakeBackendProvider,
            testing_1.MockBackend,
            http_1.BaseRequestOptions
        ],
        bootstrap: [app_component_1.AppComponent]
    })
], AppModule);
exports.AppModule = AppModule;
//# sourceMappingURL=app.module.js.map