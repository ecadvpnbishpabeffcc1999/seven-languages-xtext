package org.xtext.tortoiseshell.jvmmodel;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor.IPostIndexingInitializing;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.xtext.tortoiseshell.runtime.Tortoise;
import org.xtext.tortoiseshell.tortoiseShell.Function;
import org.xtext.tortoiseshell.tortoiseShell.Program;

@SuppressWarnings("all")
public class TortoiseShellJvmModelInferrer extends AbstractModelInferrer {
  @Inject
  private JvmTypesBuilder _jvmTypesBuilder;
  
  protected void _infer(final Program program, final IJvmDeclaredTypeAcceptor acceptor, final boolean isPreIndexingPhase) {
    JvmGenericType _class = this._jvmTypesBuilder.toClass(program, "MyTortoiseProgram");
    IPostIndexingInitializing<JvmGenericType> _accept = acceptor.<JvmGenericType>accept(_class);
    final Procedure1<JvmGenericType> _function = new Procedure1<JvmGenericType>() {
        public void apply(final JvmGenericType it) {
          XBlockExpression _body = program.getBody();
          boolean _notEquals = (!Objects.equal(_body, null));
          if (_notEquals) {
            EList<JvmMember> _members = it.getMembers();
            JvmTypeReference _newTypeRef = TortoiseShellJvmModelInferrer.this._jvmTypesBuilder.newTypeRef(program, Void.TYPE);
            final Procedure1<JvmOperation> _function = new Procedure1<JvmOperation>() {
                public void apply(final JvmOperation it) {
                  EList<JvmFormalParameter> _parameters = it.getParameters();
                  JvmTypeReference _newTypeRef = TortoiseShellJvmModelInferrer.this._jvmTypesBuilder.newTypeRef(program, Tortoise.class);
                  JvmFormalParameter _parameter = TortoiseShellJvmModelInferrer.this._jvmTypesBuilder.toParameter(program, "it", _newTypeRef);
                  TortoiseShellJvmModelInferrer.this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
                  XBlockExpression _body = program.getBody();
                  TortoiseShellJvmModelInferrer.this._jvmTypesBuilder.setBody(it, _body);
                }
              };
            JvmOperation _method = TortoiseShellJvmModelInferrer.this._jvmTypesBuilder.toMethod(program, "main", _newTypeRef, _function);
            TortoiseShellJvmModelInferrer.this._jvmTypesBuilder.<JvmOperation>operator_add(_members, _method);
          }
          EList<Function> _functions = program.getFunctions();
          for (final Function function : _functions) {
            EList<JvmMember> _members_1 = it.getMembers();
            String _name = function.getName();
            JvmTypeReference _newTypeRef_1 = TortoiseShellJvmModelInferrer.this._jvmTypesBuilder.newTypeRef(program, Void.TYPE);
            final Procedure1<JvmOperation> _function_1 = new Procedure1<JvmOperation>() {
                public void apply(final JvmOperation it) {
                  EList<JvmFormalParameter> _parameters = it.getParameters();
                  JvmTypeReference _newTypeRef = TortoiseShellJvmModelInferrer.this._jvmTypesBuilder.newTypeRef(program, Tortoise.class);
                  JvmFormalParameter _parameter = TortoiseShellJvmModelInferrer.this._jvmTypesBuilder.toParameter(program, "it", _newTypeRef);
                  TortoiseShellJvmModelInferrer.this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
                  EList<JvmFormalParameter> _parameters_1 = function.getParameters();
                  for (final JvmFormalParameter functionParameter : _parameters_1) {
                    EList<JvmFormalParameter> _parameters_2 = it.getParameters();
                    String _name = functionParameter.getName();
                    JvmTypeReference _parameterType = functionParameter.getParameterType();
                    JvmFormalParameter _parameter_1 = TortoiseShellJvmModelInferrer.this._jvmTypesBuilder.toParameter(functionParameter, _name, _parameterType);
                    TortoiseShellJvmModelInferrer.this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters_2, _parameter_1);
                  }
                  XBlockExpression _body = function.getBody();
                  TortoiseShellJvmModelInferrer.this._jvmTypesBuilder.setBody(it, _body);
                }
              };
            JvmOperation _method_1 = TortoiseShellJvmModelInferrer.this._jvmTypesBuilder.toMethod(function, _name, _newTypeRef_1, _function_1);
            TortoiseShellJvmModelInferrer.this._jvmTypesBuilder.<JvmOperation>operator_add(_members_1, _method_1);
          }
        }
      };
    _accept.initializeLater(_function);
  }
  
  public void infer(final EObject program, final IJvmDeclaredTypeAcceptor acceptor, final boolean isPreIndexingPhase) {
    if (program instanceof Program) {
      _infer((Program)program, acceptor, isPreIndexingPhase);
      return;
    } else if (program != null) {
      _infer(program, acceptor, isPreIndexingPhase);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(program, acceptor, isPreIndexingPhase).toString());
    }
  }
}
